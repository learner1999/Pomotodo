package cn.zheteng123.pomotodo.ui.countdown.entity;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2017/04/06
 *     desc   : 列表项对应实体类
 *     version: 1.0
 * </pre>
 */
public class TodoEntity {

    private String name;

    private int completedNum;

    private int expectNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(int completedNum) {
        this.completedNum = completedNum;
    }

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }
}
