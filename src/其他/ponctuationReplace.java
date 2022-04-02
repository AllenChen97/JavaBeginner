package 其他;

class ponctuationReplace {
    public static void main(String[] args){

        String stri="ss&*(,.~1如果@&(^-自己!!知道`什`么#是$苦%……Z，&那*()么一-=定——+告诉::;\"'/?.,><[]{}\\||别人什么是甜。";

        String stri1=stri.replaceAll("\\p{Punct}","");//不能完全清除标点
        System.out.println(stri1);

        String stri2=stri.replaceAll("\\pP","");//完全清除标点
        System.out.println(stri2);

        String stri4=stri.replaceAll("[\\pP\\p{Punct}]","");//清除所有符号,只留下字母 数字 汉字 共3类.
        System.out.println(stri4);
    }
}