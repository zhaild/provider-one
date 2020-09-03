package com.spring.providerone.jca;

import java.security.*;

/**
 * @author zhaild
 * @date 2020/8/811:07 PM
 * @Description: JCA安全协议加解密工具类
 */
public abstract class JCAEncryptor {

    public static void main(String args[]) {
        test();
    }



    public static void test(){
        /**
         * 消息摘要--使用MD5计算消息摘要
         */
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] testdata = {1, 2, 3, 4, 5};
            md5.update(testdata);
            byte[] myhash = md5.digest();
            System.out.println("md5="+md5+"\n"+"testdata="+testdata+"\n"+"myhash="+myhash);
        } catch (NoSuchAlgorithmException e) {
        }

        /**
         * 消息摘要--使用SHA-1计算消息摘要
         */
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] testdata = {1, 2, 3, 4, 5};
            sha.update(testdata);
            byte[] myhash = sha.digest();
            System.out.println("sha="+sha+"\n"+"testdata="+testdata+"\n"+"myhash="+myhash);
        } catch (NoSuchAlgorithmException e) {
        }

        /**
         * 密钥对的生成
         * 密钥用接口java.security.Key表示，该接口提供了3种方法:
         *
         * getAlgorithm()返回密钥算法;
         * getEncoded()返回以字节数组形式返回原始编码格式的密钥;
         * getFormat()返回密钥的编码格式。
         * DSA算法和DH算法生成公私钥对
         */
        PrivateKey privateKey = new PrivateKey() {
            @Override
            public String getAlgorithm() {
                return null;
            }

            @Override
            public String getFormat() {
                return null;
            }

            @Override
            public byte[] getEncoded() {
                return new byte[0];
            }
        };

        PublicKey publicKey = new PublicKey() {
            @Override
            public String getAlgorithm() {
                return null;
            }

            @Override
            public String getFormat() {
                return null;
            }

            @Override
            public byte[] getEncoded() {
                return new byte[0];
            }
        };

        byte[] signedData = new byte[1024];

        try {
            // 1024一bit Digital Signature Algorithm(DSA) key pairs
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            keyGen.initialize(1024);
            KeyPair keypair = keyGen.genKeyPair();
            privateKey = keypair.getPrivate();
            publicKey = keypair.getPublic();
            // 576-bit DiffieHellman key pair
            keyGen = KeyPairGenerator.getInstance("DH");
            keyGen.initialize(576);
            keypair = keyGen.genKeyPair();
            privateKey = keypair.getPrivate();
            publicKey = keypair.getPublic();
        } catch (java.security.NoSuchAlgorithmException e) {
        }

        /**
         * 数字签名的生成
         * 数字签名技术是使用公钥加密技术生成的，发送方用私钥对消息签名，而接收方用公钥对消息进行解密，
         * 从而接收方能验证消息的来源或签名者，从而确保消息的完整性和真实性。
         *
         * 私钥签名
         */
        try {
            byte[] testdata = {1, 2, 3, 4, 5};
            Signature dsig = Signature.getInstance(privateKey.getAlgorithm());
            dsig.initSign(privateKey);
            dsig.update(testdata);
            signedData = dsig.sign();
        } catch (SignatureException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }

        /**
         * 公钥验证
         */
        try {
            Signature publicDsig = Signature.getInstance(publicKey.getAlgorithm());
            publicDsig.initVerify(publicKey);
            publicDsig.update(signedData);
//            boolean result = publicDsig.verify(signatureToVerify);
        } catch (SignatureException e) {
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        }


    }
}
