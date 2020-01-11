import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        for (String cpdomain : cpdomains) {
            int idx = cpdomain.indexOf(" ");
            int times = Integer.valueOf(cpdomain.substring(0, idx));
            String domain = cpdomain.substring(idx + 1);
            map.put(domain, times);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subDomain = domain.substring(i + 1);
//                    if(map.containsKey(subDomain)) {
//                        map.put(subDomain, map.get(subDomain) + times);
//                    }else {
//                        map.put(subDomain, times);
//                    }
                    map.put(subDomain, map.getOrDefault(subDomain, 0) + times);
                }
            }
        }
        List<String> res = new ArrayList();
        for (String key : map.keySet()) res.add(map.get(key) + " " + key);
        return res;
    }

    public static void main(String[] args) {
        SubdomainVisitCount sub = new SubdomainVisitCount();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(sub.subdomainVisits(cpdomains));
    }
}
