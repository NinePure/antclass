package com.gjs.antclass;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.License;
import com.aspose.words.NodeType;
import com.aspose.words.Run;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyApplicationTestsWord {


    public static void main(String[] args) throws Exception {
        // 设置license
        License license = new License();
        String SECRET_KEY = "X0J5kak67POdoAOkslAFYQ==";
        byte[] bytes = DecryptKit.decrypt(SECRET_KEY, licenseStr.trim())
                .getBytes(StandardCharsets.UTF_8);
        license.setLicense(new ByteArrayInputStream(bytes));
        // 添加需要修改的文件夹
//        File file = new File("F:\\工作\\纪委-措施管理系统\\北京措施\\【北京】措施系统\\zzsm");
//        for (File listFile : file.listFiles()) {
//            updateDoc(listFile);
//        }
        File file = new File("F:\\工作\\纪委-措施管理系统\\北京措施\\【北京】措施系统\\文书模板\\中央系统-修改前文书模板20210305\\new\\37.1委托鉴定书.docx");
        updateDoc(file);
    }

    private static void updateDoc(File file) throws Exception {
        Document document = new Document(file.getAbsolutePath());
        DocumentBuilder builder = new DocumentBuilder(document);
        int i = 1;
        for (Run run : (Iterable<Run>)document.getChildNodes(NodeType.RUN, true)) {
            if (run.getText().equals("中国共产党中央纪律检查委员会")) {
                run.setText("");
                String bmname = "";
                bmname = "bk_dwmc" + i++;
                builder.moveTo(run);
                builder.write("中国共产党");
                builder.startBookmark(bmname);
                builder.write(" ");
                builder.endBookmark(bmname);
                builder.write("纪律检查委员会");
            }
            if (run.getText().equals("中华人民共和国国家监察委员会")) {
                run.setText("");
                String bmname = "";
                bmname = "bk_dwmc" + i++;
                builder.moveTo(run);
                builder.startBookmark(bmname);
                builder.write(" ");
                builder.endBookmark(bmname);
                builder.write("监察委员会");
            }

        }
        // 替换书签
//        document.getRange().replace("_", "】 【");
//        document.getRange().replace(Pattern.compile("【(.*?)】"), "");
//        document.getRange().replace(Pattern.compile("[\\t\\n\\r]"), "<div style=\"text-indent:2em\"/>");
        // 设置字体
//        for (Run run : (Iterable<Run>)document.getChildNodes(NodeType.RUN, true)) {
//            run.getFont().setBold(false);
//            if (run.getFont().getName().equals("方正黑体_GBK")) {
//                run.getFont().setName("黑体");
//            }else if (run.getFont().getName().equals("方正小标宋_GBK")) {
//                run.getFont().setName("方正小标宋简体");
//            }else if (run.getFont().getName().equals("方正楷体_GBK")) {
//                run.getFont().setName("楷体_GB2312");
//            }else if (run.getFont().getName().equals("方正仿宋_GBK")) {
//                run.getFont().setName("仿宋_GB2312");
//            }
//        }
        // 保存文件
        document.save("F:\\工作\\纪委-措施管理系统\\北京措施\\【北京】措施系统\\new\\" + file.getName());
    }

    public static String licenseStr = "3x1SKVRQDKIKtOC8daXiNLQmEj3q7/HpPoLAGFmxdIP3wgSYz7g5xeRF7bEOEXkwpBORreloMrCnGikEhaxxfNt9bP7Kq+ZatQkowpMkzKcS575ylfuViAYfV0h+vVF1Lr/uECfrBb5q0kjx3D3rJaVRMOFg0d8/pRcIL2RBcWJ0JRFoQ7EN/ROuR85M8N8NqMj5cr9Rl7CuFLg54I6Izqy5l0Gl0PvHgc7b0fvU4XJUK6aCmyjgzIxrLsTrdPi4PlrzfBJdTvch24dmL2WUKUNuyqELomMW8Xn9weZV524B+9YBeoymfbs0vETHnPTCHfHvBHJbPGO3qk6G8xEqI4z+8tXJEtg5Gf82/aMAF1Urkq/70WY3MXBMCAdQA6I3onmr1ZscvTq4WxhANPOucVT6l6dV4JT3eX45hy1pJU9mLS7dhEpW9a7Cr/S1m2hs42k3OtTtM3qxwg3gN0im0c9lK8lXqmtY9kmx5FFbgBGX6IBE3xmLpLdPEeSBlBHoWZLzoeRzWvWhHZyexr1yCRyc1dDD+3CocM3vyZRRI6dk19okNr0AhWHYo7wuIq2y4RNxxEGoAuI/7ocLXmRftMXCHBI44yTXByjRKoh+XjLbOl+UoBOlWSv052tJFmiwgy6rjbajC175eDSaMx66/w54iKZLz9nkByawg+FVM45pKGKInrjlfPvrhx+ZaHFJmhaWiwZ+kwYBlgi02DPjM6OPEQN5cIPNOc3e1qYE0e9m3CAdmpP6VfCJjw5K6IPksLE6QJLClWNom5SI30OvK2DYSuRc5GXj6wioQvNgchPgohpq3tK7ypAGmqDEQ6VhB6E4KyYtjG4txJZ0h3p5MkuEnER3ivskNqIj/BDmSArGg+Sr8vbCkeadHCUSFwu53Nd9Iqm6O7TbNlxP+W7TZwGxtJqCVOnemgFkb6+68vqbfykIvhr0pR2hbldasDSvHUm9cTGTUU6gmhf+UIeOCatPUFzQnipKlJzeK37AHc7uVcAMmiT9LF3gC0QvJGBpmD4oCzjApq64Vc02PvKAprDgzECoPKkO/B+ThKbYWYGkzXK4rMd0XNY/CqFauDWZ++qPj4D+KyZwzAm8UkvNrRdHU3G6eZgJvvEsCHGUvw17RaPr/uEoFxFvKieBxJC3snVsk4prRO2+4bj8babnPnd5tOcJGeCro7NO2rv8Rrx73+ATRE6d0bu6kiwNreVurFMnbXWgQJpuo4ObMZYYdQqrN28bEA8vDtbbfWP5aRI5iefBQN9nTDlcbvaP6zWbEToeFJ5OfeO2dToY4YR+rjLtR8hkJkWkY6ssig8vziYXfSsulpvVBjy0t/r/tkr5LXxOaA==\n";

}

class DecryptKit {

    /**
     * 数值 128.
     */
    private static final int N_128 = 128;

    /**
     * 数值 16.
     */
    private static final int SIXTEEN = 16;

    /**
     * AES 的 GCM 参数.
     */
    private static GCMParameterSpec gcmParamSpec = new GCMParameterSpec(N_128, new byte[SIXTEEN]);

    /**
     * 密文解密.
     *
     * @param secretKey 密钥
     * @param text 待解密文本
     * @return 解密后的原文文本
     */
    public static String decrypt(String secretKey, String text) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, getSecretKeySpec(secretKey), gcmParamSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(text)), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 将密钥转换为 SecretKeySpec 对象.
     *
     * @param key 密钥
     * @return SecretKeySpec 对象
     */
    private static SecretKeySpec getSecretKeySpec(String key) {
        return new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
    }
}