package com.password.encrypt;

import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Date;
import java.util.UUID;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * <pre>
 *  RSA公钥私钥特性：
 *  1、公钥与私钥是成对出现的。
 *  2、私钥文件中包含了公钥数据，所以可以基于私钥导出公钥。
 *  3、密钥越长，越难破解，所以2048位密钥比1024位密钥要更安全。
 *  4、公钥和私钥都是密钥，被公开的那个就是公钥，没有被公开的那个就是私钥。
 *
 *  RSA公钥和私钥都可以用于加解密操作，用公钥加密的数据只能由对应的私钥解密，反之亦然。具体使用场景：
 *  1、私钥用于签名、公钥用于验签：签名和加密作用不同，签名并不是为了保密，而是为了保证这个签名是由特定的某个人签名的，
 *而不是被其它人伪造的签名，所以私钥的私有性就适合用在签名用途上，私钥签名后，只能由对应的公钥解密，公钥又是公开的（很多人可持有），
 *所以这些人拿着公钥来解密，解密成功后就能判断出是持有私钥的人做的签名，验证了身份合法性。
 *  2、公钥用于加密、私钥用于解密：因为公钥是公开的，很多人可以持有公钥。若用私钥加密，那所有持有公钥的人都可以进行解密，这是不安全的！
 *若用公钥加密，那只能由私钥解密，而私钥是私有不公开的，只能由特定的私钥持有人解密，保证的数据的安全性。
 * </pre>
 *
 * @author lguo
 *
 */
public class RSA {

    private static final String ALGORITHOM = "RSA";
    private static final Provider DEFAULT_PROVIDER = new BouncyCastleProvider();
    public static final int KEY_SIZE = 2048;
    public static final int KEY_SIZE_1024 = 1024;
    private static KeyPairGenerator keyPairGen = null;
    private static KeyFactory keyFactory = null;

    static {
        try {
            keyPairGen = KeyPairGenerator.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
            keyFactory = KeyFactory.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
            Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);// 首次获取很慢，所以预先加载
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String encrypt(String plaintext, Key eKey) throws Exception {
        byte[] data = plaintext.getBytes();
        Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
        ci.init(Cipher.ENCRYPT_MODE, eKey);
        byte[] en_data = ci.doFinal(data);
        return new String(Hex.encodeHex(en_data));
    }

    public static String decrypt(String ciphertext, Key dKey) throws Exception {
        byte[] en_data = Hex.decodeHex(ciphertext.toCharArray());
        Cipher ci = Cipher.getInstance(ALGORITHOM, DEFAULT_PROVIDER);
        ci.init(Cipher.DECRYPT_MODE, dKey);
        byte[] data = ci.doFinal(en_data);
        return new String(data);
    }

    public static String decryptByJs(String ciphertext, PrivateKey privateKey) throws Exception {
        return StringUtils.reverse(decrypt(ciphertext, privateKey));
    }

    public static RSAPublicKey getRSAPublidKey(String hexModulus, String hexPublicExponent) throws Exception {
        byte[] modulus = Hex.decodeHex(hexModulus.toCharArray());
        byte[] publicExponent = Hex.decodeHex(hexPublicExponent.toCharArray());
        BigInteger biModulus = new BigInteger(modulus);
        BigInteger biPrivateExponent = new BigInteger(publicExponent);
        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(biModulus, biPrivateExponent);
        return (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);
    }

    public static RSAPrivateKey getRSAPrivateKey(String hexModulus, String hexPrivateExponent) throws Exception {
        byte[] modulus = Hex.decodeHex(hexModulus.toCharArray());
        byte[] privateExponent = Hex.decodeHex(hexPrivateExponent.toCharArray());
        BigInteger biModulus = new BigInteger(modulus);
        BigInteger biPrivateExponent = new BigInteger(privateExponent);
        RSAPrivateKeySpec privateKeySpec = new RSAPrivateKeySpec(biModulus, biPrivateExponent);
        return (RSAPrivateKey) keyFactory.generatePrivate(privateKeySpec);
    }

    public static KeyPair generateKeyPair() {
        return generateKeyPair(KEY_SIZE);
    }

    public static String getHexModulus(KeyPair keyPair) {
        return getHexModulus(keyPair, KEY_SIZE);
    }

    public static String getHexPrivateExponent(KeyPair keyPair) {
        return getHexPrivateExponent(keyPair, KEY_SIZE);
    }

    public static String getHexPublicExponent(KeyPair keyPair) {
        RSAPublicKey pk = (RSAPublicKey) keyPair.getPublic();
        return "0" + pk.getPublicExponent().toString(16);
    }

    public static String getHexModulus(KeyPair keyPair, int keySize) {
        RSAPrivateKey pk = (RSAPrivateKey) keyPair.getPrivate();
        return complement(keySize, pk.getModulus().toString(16));
    }

    public static String getHexPrivateExponent(KeyPair keyPair, int keySize) {
        RSAPrivateKey pk = (RSAPrivateKey) keyPair.getPrivate();
        return complement(keySize, pk.getPrivateExponent().toString(16));
    }

    public static synchronized KeyPair generateKeyPair(int keySize) {
        Date currentDate = new Date();
        String formatDate = DateFormatUtils.format(currentDate, "yyyyMMddhhmmss");
        String uuid = UUID.randomUUID().toString();
        String seed = uuid + formatDate;
        keyPairGen.initialize(keySize, new SecureRandom(seed.getBytes()));
        return keyPairGen.generateKeyPair();
    }

    private static String complement(int keySize, String str) {
        int length = keySize / 4 + 2;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < length - str.length(); i++) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}