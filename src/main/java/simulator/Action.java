package simulator;

import kr.ac.kaist.se.simulator.BaseAction;

public class Action extends BaseAction{

    private String name;
    private int raisedLocation;
    private int additionalBenefit;

    public Action(String name, int benefit, int SoSBenefit){
        this.name = name;
        this.additionalBenefit = 0;
        this.setBenefit(benefit);
        this.setSoSBenefit(SoSBenefit);
        this.setDuration(0);
        this.setRemainTime(-1); // not_raised
        this.setStatus(BaseAction.Status.NOT_RAISED);
        this.setRaisedLocation();
    }

    public String toString(){
        return this.name;
    }

    public String getName(){
        return this.name;
    }

    public void addBenefit(int additionalBenefit){
        this.additionalBenefit = additionalBenefit;
//        this.setBenefit(this.getBenefit() + additionalBenefit);
    }

    public void setRaisedLocation(){
        this.raisedLocation = (int) (( Math.random() * 12) % 6);
    }

    public void resetAction(){
        super.resetAction();
        this.additionalBenefit = 0;
    }

    public int getBenefit(){
        return super.getBenefit() + this.additionalBenefit;
    }

    public int getRaisedLocation(){
        return this.raisedLocation;
    }

    public Action clone(){
        Action copyAction = new Action(this.name, this.getBenefit(), this.getSoSBenefit());
        return copyAction;
    }

    public void reset(){
        this.resetAction();
        this.setRaisedLocation();
    }
}