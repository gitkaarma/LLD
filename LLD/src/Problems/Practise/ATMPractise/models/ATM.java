package Problems.Practise.ATMPractise.models;

public class ATM {
    private ATMState atmState;

    private Integer totalAmount;

    public ATM(Integer totalAmount, Integer totalThousandRupeeNotes, Integer totalHundredRupeeNotes, Integer totalFiftyRupeeNotes) {
        this.totalAmount = totalAmount;
        this.totalThousandRupeeNotes = totalThousandRupeeNotes;
        this.totalHundredRupeeNotes = totalHundredRupeeNotes;
        this.totalFiftyRupeeNotes = totalFiftyRupeeNotes;
    }

    private Integer totalThousandRupeeNotes;
    private Integer totalHundredRupeeNotes;
    private Integer totalFiftyRupeeNotes;


}
