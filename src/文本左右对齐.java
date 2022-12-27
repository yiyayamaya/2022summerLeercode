import java.util.ArrayList;
import java.util.List;

public class 文本左右对齐 {
    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int curLength = 0;
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (curLength + word.length() < maxWidth) {
                curLength += word.length() + 1;
                //tmp.add(word+" ");
                tmp.add(word);
            } else if (curLength + word.length() == maxWidth) {
                tmp.add(word);
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                curLength = 0;
            } else {
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                curLength = 0;
                i--;
            }
        }
        if (curLength != 0) {
            res.add(new ArrayList<>(tmp));
        }

        for (int lineCount = 0; lineCount < res.size(); lineCount++) {
            ArrayList<String> line = res.get(lineCount);
            int lengthSum = 0;
            for (String s : line) {
                //System.out.printf("\"%s\"  =%d ",s,s.length());
                lengthSum += s.length();
            }
            int spacesNeeded = maxWidth - lengthSum;
            //System.out.println("需要空格"+spacesNeeded+" "+(line.size()-1));

            if (lineCount == res.size() - 1) {
                for (int i = 0; i < line.size() - 1; i++) {
                    line.set(i, line.get(i) + " ");
                    spacesNeeded--;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < spacesNeeded; i++) {
                    sb.append(" ");
                }
                line.set(line.size() - 1, line.get(line.size() - 1) + sb.toString());
            } else {
                if (line.size() != 1) {
                    int base = spacesNeeded / (line.size() - 1);
                    int bonus = spacesNeeded % (line.size() - 1);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < base; i++) {
                        sb.append(" ");
                    }
                    for (int i = 0; i < line.size() - 1; i++) {
                        line.set(i, line.get(i) + sb.toString());
                    }
                    for (int i = 0; i < bonus; i++) {
                        line.set(i, line.get(i) + " ");
                    }
                } else {
                    int base = spacesNeeded;
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < base; i++) {
                        sb.append(" ");
                    }
                    line.set(0, line.get(0) + sb.toString());
                }
            }

        }

        //System.out.println(res);
        List<String> res2 = new ArrayList<>();
        for (ArrayList<String> list : res) {
            res2.add(String.join("", list));
        }
        return res2;

    }

    public String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }


}
