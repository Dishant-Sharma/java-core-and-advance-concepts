public class test {
    int instanceVar;
    public static int staticVar;

//    public void sum() {
//        System.out.println("hello");
//    }
//
//    public static void sumStatic() {
//        System.out.println(staticVar);
//    }


//    public static void main(String[] args) {
//        String s = "abBAcC";
//        String t = "";
//        while (s != t) {
//            t = s;
//            for (int i = 0; i < s.length() - 1; i++) {
//                if (s.charAt(i) == s.charAt(i + 1) + 32 || s.charAt(i) + 32 == s.charAt(i + 1)) {
//                    s = s.substring(0, i) + s.substring(i + 2);
//                }
//            }
//        }
//        System.out.println(s);         `
//    }
//    public static void main(String[] args) {
//        String s = " abBAcC";
//        StringBuilder sb = new StringBuilder();
////        boolean hasChanged = true;
//////        while (hasChanged) {
////            hasChanged = false;
//
//            for (char c : s.toCharArray()) {
//                if (sb.length()> 0 && Math.abs(sb.charAt(sb.length() - 1)) - c == 32 ) {
//                    sb.deleteCharAt(sb.length() - 1);
////                    hasChanged = true;
//                } else {
//                    sb.append(c);
//                }
////            }
//        }
//        System.out.println(sb.toString());
//    }

    //    StringBuilder sb = new StringBuilder();
////        boolean hasChanged = true;
//////        while (hasChanged) {
////            hasChanged = false;
//
//            for (char c : s.toCharArray()) {
//        if (sb.length() > 0 && Character.toLowerCase(sb.charAt(sb.length() - 1)) == Character.toLowerCase(c) && sb.charAt(sb.length() - 1) != c) {
//            sb.deleteCharAt(sb.length() - 1);
//        } else {
//            sb.append(c);
//        }
////            }
//    }
//        return sb.toString();

    public static void main(String[] args) {
        String s = "abBAcC";
//        List<Character> result = new ArrayList();
//        result.add(' ');
        String result = "";
        char[] ch = s.toCharArray();
//        while(result.length() != 1) {
        // Traverse the character array
        for (int i = 0; i < ch.length; i++) {
            if (!result.isEmpty() && result.charAt(result.length() - 1) + 32 == ch[i] ||
                    result.charAt(result.length() - 1) - 32 == ch[i]) {
//                result.remove(result.get(result.size()-1));
                result = result.substring(0, result.length() - 1);
            } else {
                result = result + ch[i];
            }
        }
            System.out.println(result);
    }
}
