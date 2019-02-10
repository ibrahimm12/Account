package hello;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

  //  @Column( name = " entry_date" , length = 255)
    private String entryDate;
  //  @Column( name = " value_date" , length = 255)
    private String valueDate;
  //  @Column( name = " payment_date" , length = 255)
    private String paymentDate;
  //  @Column( name = " amount" , length = 255)
    private String amount;
  //  @Column( name = " beneficiary" , length = 255)
    private String beneficiary;
   // @Column( name = " account_number" , length = 255)
    private String accountNumber;
  //  @Column( name = " reference_number" , length = 255)
    private String referenceNumber;
  //  @Column( name = " originators_number" , length = 255)
    private String originatorsNumber;
   // @Column( name = " message_card_number" , length = 255)
    private String messageCardNumber;
    //@Column( name = " receipt" , length = 255)
    private String receipt;

    protected Account(){

    }


    public Account (String entryDate,
                    String valueDate ,
                    String paymentDate,
                    String amount,
                    String beneficiary,
                    String accountNumber,
                    String referenceNumber,
                    String originatorsNumber,
                    String messageCardNumber,
                    String receipt) {

        this.entryDate = entryDate;
        this.valueDate= valueDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.beneficiary = beneficiary;
        this.accountNumber = accountNumber;
        this.referenceNumber = referenceNumber;
        this.originatorsNumber = originatorsNumber;
        this.messageCardNumber = messageCardNumber;
        this.receipt = receipt;
    }

    public Long getId() {
        return id;
    }


    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }



    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getOriginatorsNumber() {
        return originatorsNumber;
    }

    public void setOriginatorsNumber(String originatorsNumber) {
        this.originatorsNumber = originatorsNumber;
    }

    public String getMessageCardNumber() {
        return messageCardNumber;
    }

    public void setMessageCardNumber(String messageCardNumber) {
        this.messageCardNumber = messageCardNumber;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return String.format("Account[id=%d,  entryDate='%s',   valueDate='%s',   paymentDate='%s', amount='%s',  beneficiary='%s',  accountNumber='%s',  referenceNumber='%s',  originatorsNumber='%s', messageCardNumber='%s', receipt='%s' ]",
                id,
                entryDate,
                valueDate,
                paymentDate,
                amount,
                beneficiary,
                accountNumber,
                referenceNumber,
                originatorsNumber,
                messageCardNumber,
                receipt );
    }
}