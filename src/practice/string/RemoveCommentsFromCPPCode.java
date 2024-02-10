package practice.string;

import java.util.ArrayList;
import java.util.List;

public class RemoveCommentsFromCPPCode {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean multiLineCommentFound = false;
        for (String line : source) {
            if (line.contains("//")) {
                int id = line.indexOf("//");
                if (id > 0) {
                    line = line.substring(0, id);
                    res.add(line);
                }
            }
            else if (line.trim().startsWith("/*") && line.trim().endsWith("*/")) continue;
            else if (line.trim().startsWith("/*")) multiLineCommentFound = true;
            else if (line.trim().endsWith("*/")) multiLineCommentFound = false;
            else if (!multiLineCommentFound) res.add(line);
        }
        return res;
    }
}
