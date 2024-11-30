package chlopaki.z.frontu.hobby.domain;

public class Form {

    int time;
    boolean riskyActivities;
    boolean isIndyvidual;
    boolean isSpontanic;
    boolean freshAirActivities;
    boolean isCreative;
    boolean manualActivities;
    boolean likesScience;
    boolean likeHistory;
    boolean likesNature;

    public Form() {}

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isRiskyActivities() {
        return riskyActivities;
    }

    public void setRiskyActivities(boolean riskyActivities) {
        this.riskyActivities = riskyActivities;
    }

    public boolean isIndyvidual() {
        return isIndyvidual;
    }

    public void setIndyvidual(boolean indyvidual) {
        isIndyvidual = indyvidual;
    }

    public boolean isSpontanic() {
        return isSpontanic;
    }

    public void setSpontanic(boolean spontanic) {
        isSpontanic = spontanic;
    }

    public boolean isFreshAirActivities() {
        return freshAirActivities;
    }

    public void setFreshAirActivities(boolean freshAirActivities) {
        this.freshAirActivities = freshAirActivities;
    }

    public boolean isCreative() {
        return isCreative;
    }

    public void setCreative(boolean creative) {
        isCreative = creative;
    }

    public boolean isManualActivities() {
        return manualActivities;
    }

    public void setManualActivities(boolean manualActivities) {
        this.manualActivities = manualActivities;
    }

    public boolean isLikesScience() {
        return likesScience;
    }

    public void setLikesScience(boolean likesScience) {
        this.likesScience = likesScience;
    }

    public boolean isLikeHistory() {
        return likeHistory;
    }

    public void setLikeHistory(boolean likeHistory) {
        this.likeHistory = likeHistory;
    }

    public boolean isLikesNature() {
        return likesNature;
    }

    public void setLikesNature(boolean likesNature) {
        this.likesNature = likesNature;
    }
}
