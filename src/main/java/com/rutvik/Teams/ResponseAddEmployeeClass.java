package com.rutvik.Teams;

public class ResponseAddEmployeeClass {
    private String add;
    private String remove;

//    public ResponseAddEmployeeClass(ResponseAddEmployeeClass empId) {
//        this.add = empId.add;
//        this.remove = empId.remove;
//    }

    public String getAdd() {
        return add;
    }

    public String getRemove() {
        return remove;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }
}
