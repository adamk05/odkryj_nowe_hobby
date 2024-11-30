package chlopaki.z.frontu.hobby.domain;


/**
 * Klasa przechowująca wartości z formularza
 */
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

    /**
     * Konstruktor domyślny
     */
    public Form() {}

    /**
     * Pobiera czas
     * @return czas
     */
    public int getTime() {
        return time;
    }

    /**
     * Ustawia czas
     * @param time czas
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Pobiera wartość logiczną ryzykownych aktywności
     * @return ryzykowna aktywność (true lub false)
     */
    public boolean isRiskyActivities() {
        return riskyActivities;
    }

    /**
     * Ustawia wartość logiczną ryzykownych aktywności
     * @param riskyActivities ryzykowna aktywność (true lub false)
     */
    public void setRiskyActivities(boolean riskyActivities) {
        this.riskyActivities = riskyActivities;
    }

    /**
     * Pobiera wartość logiczną bycia indywidualnym
     * @return indywidualny (true lub false)
     */
    public boolean isIndyvidual() {
        return isIndyvidual;
    }

    /**
     * Ustawia wartość logiczną bycia indywidualnym
     * @param indyvidual indywidualny (true lub false)
     */
    public void setIndyvidual(boolean indyvidual) {
        isIndyvidual = indyvidual;
    }

    /**
     * Pobiera wrtość logiczną spontaniczności
     * @return spontaniczny (true lub false)
     */
    public boolean isSpontanic() {
        return isSpontanic;
    }

    /**
     * Ustawia wartość logiczną spontaniczności
     * @param spontanic spontaniczny (true lub false)
     */
    public void setSpontanic(boolean spontanic) {
        isSpontanic = spontanic;
    }

    /**
     * Pobiera wartość logiczną aktywności na świerzym powietrzu
     * @return aktywności na świerzym powietrzu (true lub false)
     */
    public boolean isFreshAirActivities() {
        return freshAirActivities;
    }

    /**
     * Ustawia wartość logiczną aktywności na świerzym powietrzu
     * @param freshAirActivities aktywności na świerzym powietrzu (true lub false)
     */
    public void setFreshAirActivities(boolean freshAirActivities) {
        this.freshAirActivities = freshAirActivities;
    }

    /**
     * Pobiera wartość logiczną bycia kreatywnym
     * @return kreatywność (true lub false)
     */
    public boolean isCreative() {
        return isCreative;
    }

    /**
     * Ustawia wartość logiczną bycia kreatywnym
     * @param creative kreatywność (true lub false)
     */
    public void setCreative(boolean creative) {
        isCreative = creative;
    }

    /**
     * Pobiera wartość logiczną aktywności manualnych
     * @return aktywności manualne (true lub false)
     */
    public boolean isManualActivities() {
        return manualActivities;
    }

    /**
     * Ustawia wartość logiczną aktywności manualnych
     * @param manualActivities aktywności manualne (true lub false)
     */
    public void setManualActivities(boolean manualActivities) {
        this.manualActivities = manualActivities;
    }

    /**
     * Pobiera wartość logiczną zainteresowania w nauce
     * @return zainteresowanie w nauce (true lub false)
     */
    public boolean isLikesScience() {
        return likesScience;
    }

    /**
     * Ustawia wartość logiczną zainteresowania w nauce
     * @param likesScience zainteresowanie w nauce (true lub false)
     */
    public void setLikesScience(boolean likesScience) {
        this.likesScience = likesScience;
    }

    /**
     * Pobiera wartość logiczną zainteresowania historią
     * @return zainteresowanie historią (true lub false)
     */
    public boolean isLikeHistory() {
        return likeHistory;
    }

    /**
     * Ustawia wartość logiczną zainteresowania historią
     * @param likeHistory zainteresowanie historią (true lub false)
     */
    public void setLikeHistory(boolean likeHistory) {
        this.likeHistory = likeHistory;
    }

    /**
     * Pobiera wartość logiczną zainteresowania naturą
     * @return zainteresowanie naturą (true lub false)
     */
    public boolean isLikesNature() {
        return likesNature;
    }

    /**
     * Ustawia wartość logiczną zainteresowania naturą
     * @param likesNature zainteresowanie naturą (true lub false)
     */
    public void setLikesNature(boolean likesNature) {
        this.likesNature = likesNature;
    }
}
