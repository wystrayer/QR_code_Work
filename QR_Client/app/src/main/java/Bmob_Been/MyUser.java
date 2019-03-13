package Bmob_Been;

import cn.bmob.v3.BmobUser;

/**
 * Created by admin on 2018/3/8.
 */

public class MyUser extends BmobUser {
    private String sex;
    private String interest;
    private String qq;
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
