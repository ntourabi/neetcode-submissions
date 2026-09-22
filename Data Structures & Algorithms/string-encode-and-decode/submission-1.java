class Solution {

    public String encode(List<String> strs) {
        String encodedStr = "";
        for (String s : strs) {
            encodedStr += s.length() + "#" + s;
        }
        return encodedStr;
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> strs = new ArrayList<>();
        char[] cs = str.toCharArray();
        //two phase
        //phase 1 - reading numbers until we see #
        //phase 2 - using number we read to read next letters before going into phase 1
        boolean numberPhase = true;
        String word = "";
        String numStr = "";
        int numInt = -1;
        for (int i = 0; i < cs.length; i++) {
            if (numberPhase) {
                if (cs[i] != '#') {
                    numStr += cs[i];
                } else {
                    numInt = Integer.parseInt(numStr);
                    if (numInt != 0) {
                        numStr = "";
                        numberPhase = false;
                    } else {
                        strs.add("");
                    }
                    
                }
            } else {
                word += cs[i];
                numInt -= 1;
                if (numInt == 0) {
                    strs.add(word);
                    word = "";
                    numberPhase = true;
                }
                
            }
        }
        return strs;
    }
}
