package neu.edu.his.bean;

public class DoctorBean {
    private int docid;
    private String loginId;
    private String password;
    private String docName;
    private String docType;
    private String docTitle;
    private String doesWorkList;
    private int deptId;
    private String regisLevel;

    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwrd) {
        this.password = passwrd;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public String getDoesWorkList() {
        return doesWorkList;
    }

    public void setDoesWorkList(String doesWorkList) {
        this.doesWorkList = doesWorkList;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getRegisLevel() {
        return regisLevel;
    }

    public void setRegisLevel(String regisLevel) {
        this.regisLevel = regisLevel;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    private String isDeleted;
}
