
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Sort {

    //private final int noErasmus;
    //private final int maxErasmus;
    private LinkedList<Erasmus> erasmus;
    private LinkedList<Erasmus> erasmusToDivide;
    private LinkedList<Erasmus> erasmusLeft;
    private LinkedList<Mentor> mentors;
    private LinkedList<Mentor> mentorsToDivade;
    private HashMap<Mentor, LinkedList<Erasmus>> wynik;

    public Sort(int noErasmus, int maxErasmus, LinkedList erasmus, LinkedList mentors) {
        this.erasmus = erasmus;
        this.mentors = mentors;
        this.erasmusToDivide = new LinkedList<>();
        this.mentorsToDivade = new LinkedList<>();
        this.wynik = new HashMap<>();
        HashMap<Mentor, LinkedList<Erasmus>> tempWynik;
        while (getErasmus().size() > 0) {
            getErasmusToDivide().add(getErasmus().removeFirst());
            String language = getErasmusToDivide().getFirst().getNativeLanguage();
            int erasmusSize = getErasmus().size();
            for (int i = 0; i < erasmusSize; i++) {
                if (getErasmus().getFirst().getNativeLanguage().equals(language))
                    getErasmusToDivide().add(getErasmus().removeFirst());
                else
                    getErasmus().addLast(getErasmus().removeFirst());
            }
            int mentorSize = getMentors().size();
            for (int i = 0; i < mentorSize; i++) {
                if (getMentors().getFirst().getLanguage().equals(language))
                    getMentorsToDivade().add(getMentors().removeFirst());
                else
                    getMentors().addLast(getMentors().removeFirst());
            }
            tempWynik = Divide();
            this.wynik.putAll(tempWynik);
            getMentorsToDivade().clear();
        }
        System.out.println();
        System.out.println("Osoby nieprzydzielone: ");
        for(int k=0;k<erasmusLeft.size();k++)
            System.out.println(erasmusLeft);

    }

    private HashMap Divide(){
        HashMap<Mentor, LinkedList<Erasmus>> tempWynik = new HashMap<>();
        int mean = getErasmusToDivide().size() / (getMentorsToDivade().size());
        for (int i = 0; i < getMentorsToDivade().size(); i++) {
            LinkedList<Erasmus> eList = new LinkedList<>();
            Mentor m = getMentorsToDivade().get(i);
            for (int j = 0; j < mean && j < m.getNumberOfErasmus(); j++) {
                Erasmus e = getErasmusToDivide().removeFirst();
                    eList.add(e);
            }
            if (eList.size() > 0) {
                tempWynik.put(m, eList);
            }
        }
        while(getErasmusToDivide().size() > 0) {
            Erasmus e = getErasmusToDivide().removeFirst();
            Mentor m = getMentorsToDivade().removeFirst();
            if (m.getNumberOfErasmus() > tempWynik.get(m).size()) {
                LinkedList<Erasmus> tempList = tempWynik.get(m);
                tempList.add(e);
                tempWynik.replace(m, tempList);
                getMentorsToDivade().add(m);
            } else {
                getErasmusToDivide().addFirst(e);
            }
            if (getMentorsToDivade().size() == 0) {
                setErasmusLeft(getErasmusToDivide());
                getErasmusToDivide().clear();
            }
        }

        return tempWynik;
    }

    public LinkedList<Erasmus> getErasmus() {
        return erasmus;
    }

    public LinkedList<Erasmus> getErasmusToDivide() {
        return erasmusToDivide;
    }

    public LinkedList<Erasmus> getErasmusLeft() {
        return erasmusLeft;
    }

    public LinkedList<Mentor> getMentors() {
        return mentors;
    }

    public LinkedList<Mentor> getMentorsToDivade() {
        return mentorsToDivade;
    }

    public HashMap<Mentor, LinkedList<Erasmus>> getWynik() {
        return wynik;
    }

    public void setErasmusLeft(LinkedList<Erasmus> erasmusLeft) {
        this.erasmusLeft = erasmusLeft;
    }
}
