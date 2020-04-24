package com.example.demo.Model;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Calculate {
	Input i;
	static double d[][]={{0,4,0,3},{4,0,3,2.5},{0,3,0,2},{3,2.5,2,0}};
    static double weight[]={3,2,8,12,25,15,0.5,1,2},tw[];
    
    static double ans=Double.MAX_VALUE;
    
   
    //To determine the total cost required per unit
    static double tC(double tW){
        double res=8d*Math.ceil(((tW-5)/5))+10d;;
        return res;
    }
    //Pick from one and drop
    static double oneoneone(int i,int j,int k){
        double res=tC(tw[i])*d[i][3]+(tw[j]==0?0:(d[j][3]*(10+tC(tw[j]))))+(tw[k]==0?0:(d[k][3]*(10+tC(tw[k]))));
        return res;
    }
    //Pick from two warehouses,drop,pick from third and drop
    static double twoone(int i,int j,int k){
        double res=d[i][j]*tC(tw[i])+d[j][3]*(tC(tw[i]+tw[j]))+(tw[k]==0?0:(d[k][3]*(tC(tw[k])+10)));
        return res;
    }
    //Pick from one warehouse,drop,pick from the other two and drop
    static double onetwo(int i,int j,int k){
        double res=d[i][3]*tC(tw[i])+d[3][j]*10d+d[j][k]*tC(tw[j])+d[k][3]*tC(tw[j]+tw[k]);
        return res;
    }
    //Pick from the three warehouses and drop
    static double three(int i,int j,int k){
        double res=d[i][j]*tC(tw[i])+d[j][k]*tC(tw[i]+tw[j])+d[k][3]*tC(tw[i]+tw[j]+tw[k]);
        return res;
    }
	public Calculate(Input i) {
		super();
		this.i = i;
	}
	public String cal() {
		tw=new double[3];
		tw[0]+=Double.parseDouble((i.getA().length()==0)?"0":i.getA())*weight[0]+Double.parseDouble((i.getB().length()==0)?"0":i.getB())*weight[1]+Double.parseDouble((i.getC().length()==0)?"0":i.getC())*weight[2];
		tw[1]+=Double.parseDouble((i.getD().length()==0)?"0":i.getD())*weight[3]+Double.parseDouble((i.getE().length()==0)?"0":i.getE())*weight[4]+Double.parseDouble((i.getF().length()==0)?"0":i.getF())*weight[5];
		tw[2]+=Double.parseDouble((i.getG().length()==0)?"0":i.getG())*weight[6]+Double.parseDouble((i.getH().length()==0)?"0":i.getH())*weight[7]+Double.parseDouble((i.getI().length()==0)?"0":i.getI())*weight[8];
		
		double ans1=0;
	       
	       //Starting with C1
	       ans1=oneoneone(0,1,2);
	       ans=Math.min(ans, ans1);
	       ans1=twoone(0,1,2);
	       ans=Math.min(ans, ans1);
	       ans1=onetwo(0,1,2);
	       ans=Math.min(ans, ans1);
	       ans1=onetwo(0,2,1);
	       ans=Math.min(ans, ans1);
	       ans1=three(0,1,2);
	       ans=Math.min(ans, ans1);
	       
	       //Starting with C2
	       ans1=oneoneone(1,0,2);
	       ans=Math.min(ans, ans1);
	       ans1=twoone(1,0,2);
	       ans=Math.min(ans, ans1);
	       ans1=twoone(1,2,0);
	       ans=Math.min(ans, ans1);
	       
	       //Starting with C3
	       ans1=oneoneone(2,0,1);
	       ans=Math.min(ans, ans1);
	       ans1=twoone(2,1,0);
	       ans=Math.min(ans, ans1);
	       ans1=onetwo(2,1,0);
	       ans=Math.min(ans, ans1);
	       ans1=onetwo(2,0,1);
	       ans=Math.min(ans, ans1);
	       ans1=three(0,1,2);
	       ans=Math.min(ans, ans1);
	       //System.out.println(ans);
	       String res=Double.toString(ans);
	       return res;
	}
}
