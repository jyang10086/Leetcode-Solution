class LC721 {
  Map<String, String> parentEmailMap;
  Map<String, String> emailOwnerMap;
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    /***
     1. build map <email , name>
     2. build map <email, parent>
     3. union merge same parent
     4. Treeset<email, email[]>  , sort email[]
     5. output list[][]
     time: O(nlogn)
     */
    emailOwnerMap = new HashMap<>();
    parentEmailMap = new HashMap<>();
    for (List<String> account : accounts) {
      String owner = account.get(0);
      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        emailOwnerMap.put(account.get(i), owner);
        parentEmailMap.put(email, email);
      }
    }
    // connect parent
    for (List<String> account : accounts) {
      String parent = getParent(account.get(1));
      for (int i = 2; i < account.size(); i++) {
        String curParent = getParent(account.get(i));
        parentEmailMap.put(curParent, parent);
      }
    }
    // union set
    Map<String, TreeSet<String>> emailUnions = new HashMap<>();
    for (List<String> account : accounts) {
      String parent = getParent(account.get(1));
      emailUnions.putIfAbsent(parent, new TreeSet<>());
      for (int i = 1; i < account.size(); i++) {
        emailUnions.get(parent).add(account.get(i));
      }
    }
    //get res
    List<List<String>> res = new ArrayList<>();
    for (String parent : emailUnions.keySet()) {
      // System.out.println(parent);
      List<String> emails = new ArrayList(emailUnions.get(parent));
      emails.add(0, emailOwnerMap.get(parent));
      res.add(emails);
    }
    return res;
  }

  private String getParent(String email) {
    if (!parentEmailMap.get(email).equals(email)) {
      return getParent(parentEmailMap.get(email));
    }
    return email;
  }
}