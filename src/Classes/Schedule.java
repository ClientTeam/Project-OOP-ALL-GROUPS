
package ooadass1;

import java.util.*;

/**
 *
 * @author John
 */
public class Schedule {
    
    List<Exam> examList = new ArrayList<Exam>();
    
    
    public Schedule(List<Exam> loe)
    {
        this.examList = loe;
    }
    

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
    
}
