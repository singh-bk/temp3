package com.uber.www;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ReportingHierarchyTest {

    public static void main(String[] args) {
        final Emp ceo = new Emp("RW");
        
        final Emp cto = new Emp("JJH");
        
        final Emp coo = new Emp("SK");
        final Emp cpo = new Emp("SB");
        ceo.reportees.add(cto);
        ceo.reportees.add(coo);
        ceo.reportees.add(cpo);
        final Emp vp1 = new Emp("KB");
        final Emp vp2 = new Emp("BM");
        coo.reportees.add(vp1);
        coo.reportees.add(vp2);
        final Emp vp3 = new Emp("VP");
        
        final Emp vp4 = new Emp("MW");
        cto.reportees.add(vp3);
        cto.reportees.add(vp4);
        final Emp ed1 = new Emp("SB");
        final Emp ed2 = new Emp("CB");
        final Emp ed3 = new Emp("MM");
        final Emp ed4 = new Emp("MC");
        final Emp ed5 = new Emp("AM");
        final Emp ed6 = new Emp("AB");
        final Emp ed7 = new Emp("TT");
        final Emp ed8 = new Emp("CC");
        
        vp4.reportees.add(ed1);
        vp4.reportees.add(ed2);
        vp4.reportees.add(ed3);
        vp4.reportees.add(ed4);
        vp3.reportees.add(ed5);
        vp3.reportees.add(ed6);
        vp3.reportees.add(ed7);
        vp3.reportees.add(ed8);
        
        final Emp e1 = new Emp("BKS");
        
        final Emp e2 = new Emp("SP");
        ed1.reportees.add(e1);
        ed1.reportees.add(e2);
        final Emp e3 = new Emp("AT");
        final Emp e4 = new Emp("AK");
        ed2.reportees.add(e3);
        ed2.reportees.add(e4);
        final Emp e5 = new Emp("NA");
        ed3.reportees.add(e5);
        final Emp e6 = new Emp("MM1");
        ed4.reportees.add(e6);
        
        
        final ReportingHierarchyTest obj = new ReportingHierarchyTest();
        final List<String> hier = new ArrayList<String>();
        obj.getHierarchy(ceo, "BKS", hier);
        System.out.println(hier);
        final List<Emp> emps = obj.getHierarchyBFS(ceo, "BKS");
        for(final Emp ee: emps) {
            System.out.print(ee.name+ " ");
        }
        
    }
    
    public boolean getHierarchy(Emp emp, String srch, List<String> hier) {
        if(emp == null) {
            return false;
        }
        if(emp.name.equals(srch)) {
            return true;
        }
        hier.add(emp.name);
        for(final Emp ee: emp.reportees) {
            if(getHierarchy(ee, srch, hier)) {
                return true;
            }
        }
        hier.remove(hier.size()-1);
        return false;
    }
    
    
    public List<Emp> getHierarchyBFS(Emp emp, String srch) {
        final Queue<List<Emp>> queue1 = new LinkedList<List<Emp>>();
        final Queue<List<Emp>> queue2 = new LinkedList<List<Emp>>();
        final List<Emp> list = new ArrayList<Emp>();
        list.add(emp);
        queue1.add(list);
        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if(!queue1.isEmpty()) {
                final List<Emp> ll = queue1.remove();
                final Emp nn = ll.get(ll.size()-1);
                if(nn.name.equals(srch)) {
                    ll.remove(ll.size()-1);
                    return ll;
                }else {
                    if(nn.reportees != null) {
                        for(final Emp ee: nn.reportees) {
                            final List<Emp> ll2 = new ArrayList<Emp>();
                            ll2.addAll(ll);
                            ll2.add(ee);
                            queue2.add(ll2);
                        }
                    }
                }
            }
            if(!queue2.isEmpty()) {
                final List<Emp> ll = queue2.remove();
                final Emp nn = ll.get(ll.size()-1);
                if(nn.name.equals(srch)) {
                    return ll;
                }else {
                    if(nn.reportees != null) {
                        for(final Emp ee: nn.reportees) {
                            final List<Emp> ll2 = new ArrayList<Emp>();
                            ll2.addAll(ll);
                            ll2.add(ee);
                            queue1.add(ll2);
                        }
                    }
                }
            }
        }
        
        return null;
    }
}

class Emp{
    String name;
    List<Emp> reportees;
    Emp(String n){
        name = n;
        reportees = new ArrayList<Emp>();
    }
}  

