package com.spring.providerone.jce;

/**
 * @author zhaild
 * @date 2020/8/91:38 PM
 * @Description: DES算法加解密
 * <p>
 * 加密是一种打乱消息、文件或程序的加密技术。JCE基本的加密和解密流程如下所示：
 * <p>
 * 生成密钥
 * 创建Cipher对象
 * 为加密而初始化Cipher对象
 * 为解密而初始化Cipher对象
 */


import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES安全编码组件
 *
 * @author AllenWells
 * @version 1.0
 */
public abstract class DESEncryptor {

    public static void main(String arg[]) throws Exception{
        String data = "123456";
        String key = "ASDFGHJKL";
        byte[] encryptPwd = encrypt(data.getBytes(),key.getBytes());
        byte[] decriptPwd = decrypt(encryptPwd,key.getBytes());

        System.out.println(encryptPwd);
        System.out.println(decriptPwd);
    }
    /**
     * 密钥算法 <br>
     * Java 6 只支持56bit密钥 <br>
     * Bouncy Castle 支持64bit密钥
     */
    public static final String KEY_ALGORITHM = "DES";

    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     */
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5PADDING";

    /**
     * 转换密钥
     *
     * @param key
     *            二进制密钥
     * @return Key 密钥
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {

        // 实例化DES密钥材料
        DESKeySpec dks = new DESKeySpec(key);

        // 实例化秘密密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(KEY_ALGORITHM);

        // 生成秘密密钥
        SecretKey secretKey = keyFactory.generateSecret(dks);

        return secretKey;
    }

    /**
     * 解密
     *
     * @param data
     *            待解密数据
     * @param key
     *            密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

        // 还原密钥
        Key k = toKey(key);

        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        // 初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);

        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * 加密
     *
     * @param data
     *            待加密数据
     * @param key
     *            密钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {

        // 还原密钥
        Key k = toKey(key);

        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        // 初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);

        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * 生成密钥 <br>
     * Java 6 只支持56bit密钥 <br>
     * Bouncy Castle 支持64bit密钥 <br>
     *
     * @return byte[] 二进制密钥
     * @throws Exception
     */
    public static byte[] initKey() throws Exception {

        /*
         * 实例化密钥生成器
         *
         * 若要使用64bit密钥注意替换 将下述代码中的KeyGenerator.getInstance(CIPHER_ALGORITHM);
         * 替换为KeyGenerator.getInstance(CIPHER_ALGORITHM, "BC");
         */
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);

        /*
         * 初始化密钥生成器 若要使用64bit密钥注意替换 将下述代码kg.init(56); 替换为kg.init(64);
         */
        kg.init(56, new SecureRandom());

        // 生成秘密密钥
        SecretKey secretKey = kg.generateKey();

        // 获得密钥的二进制编码形式
        return secretKey.getEncoded();
    }
}

