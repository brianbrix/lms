package com.company.lms.model.soap;

import com.company.lms.utilis.DateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

public class Transactions {
    @Override
    public String toString() {
        return "Transactions{" +
                "alternativechanneltrnscrAmount=" + alternativechanneltrnscrAmount +
                ", alternativechanneltrnscrNumber=" + alternativechanneltrnscrNumber +
                ", alternativechanneltrnsdebitAmount=" + alternativechanneltrnsdebitAmount +
                ", alternativechanneltrnsdebitNumber=" + alternativechanneltrnsdebitNumber +
                ", atmTransactionsNumber=" + atmTransactionsNumber +
                ", atmtransactionsAmount=" + atmtransactionsAmount +
                ", bouncedChequesDebitNumber=" + bouncedChequesDebitNumber +
                ", bouncedchequescreditNumber=" + bouncedchequescreditNumber +
                ", bouncedchequetransactionscrAmount=" + bouncedchequetransactionscrAmount +
                ", bouncedchequetransactionsdrAmount=" + bouncedchequetransactionsdrAmount +
                ", chequeDebitTransactionsAmount=" + chequeDebitTransactionsAmount +
                ", chequeDebitTransactionsNumber=" + chequeDebitTransactionsNumber +
                ", createdAt=" + createdAt +
                ", createdDate=" + createdDate +
                ", credittransactionsAmount=" + credittransactionsAmount +
                ", debitcardpostransactionsAmount=" + debitcardpostransactionsAmount +
                ", debitcardpostransactionsNumber=" + debitcardpostransactionsNumber +
                ", fincominglocaltransactioncrAmount=" + fincominglocaltransactioncrAmount +
                ", id=" + id +
                ", incominginternationaltrncrAmount=" + incominginternationaltrncrAmount +
                ", incominginternationaltrncrNumber=" + incominginternationaltrncrNumber +
                ", incominglocaltransactioncrNumber=" + incominglocaltransactioncrNumber +
                ", intrestAmount=" + intrestAmount +
                ", lastTransactionDate=" + lastTransactionDate +
                ", lastTransactionValue=" + lastTransactionValue +
                ", maxAtmTransactions=" + maxAtmTransactions +
                ", maxMonthlyBebitTransactions=" + maxMonthlyBebitTransactions +
                ", maxalternativechanneltrnscr=" + maxalternativechanneltrnscr +
                ", maxalternativechanneltrnsdebit=" + maxalternativechanneltrnsdebit +
                ", maxbouncedchequetransactionscr=" + maxbouncedchequetransactionscr +
                ", maxchequedebittransactions=" + maxchequedebittransactions +
                ", maxdebitcardpostransactions=" + maxdebitcardpostransactions +
                ", maxincominginternationaltrncr=" + maxincominginternationaltrncr +
                ", maxincominglocaltransactioncr=" + maxincominglocaltransactioncr +
                ", maxmobilemoneycredittrn=" + maxmobilemoneycredittrn +
                ", maxmobilemoneydebittransaction=" + maxmobilemoneydebittransaction +
                ", maxmonthlycredittransactions=" + maxmonthlycredittransactions +
                ", maxoutgoinginttrndebit=" + maxoutgoinginttrndebit +
                ", maxoutgoinglocaltrndebit=" + maxoutgoinglocaltrndebit +
                ", maxoverthecounterwithdrawals=" + maxoverthecounterwithdrawals +
                ", minAtmTransactions=" + minAtmTransactions +
                ", minMonthlyDebitTransactions=" + minMonthlyDebitTransactions +
                ", minalternativechanneltrnscr=" + minalternativechanneltrnscr +
                ", minalternativechanneltrnsdebit=" + minalternativechanneltrnsdebit +
                ", minbouncedchequetransactionscr=" + minbouncedchequetransactionscr +
                ", minchequedebittransactions=" + minchequedebittransactions +
                ", mindebitcardpostransactions=" + mindebitcardpostransactions +
                ", minincominginternationaltrncr=" + minincominginternationaltrncr +
                ", minincominglocaltransactioncr=" + minincominglocaltransactioncr +
                ", minmobilemoneycredittrn=" + minmobilemoneycredittrn +
                ", minmobilemoneydebittransaction=" + minmobilemoneydebittransaction +
                ", minmonthlycredittransactions=" + minmonthlycredittransactions +
                ", minoutgoinginttrndebit=" + minoutgoinginttrndebit +
                ", minoutgoinglocaltrndebit=" + minoutgoinglocaltrndebit +
                ", minoverthecounterwithdrawals=" + minoverthecounterwithdrawals +
                ", mobilemoneycredittransactionAmount=" + mobilemoneycredittransactionAmount +
                ", mobilemoneycredittransactionNumber=" + mobilemoneycredittransactionNumber +
                ", mobilemoneydebittransactionAmount=" + mobilemoneydebittransactionAmount +
                ", mobilemoneydebittransactionNumber=" + mobilemoneydebittransactionNumber +
                ", monthlyBalance=" + monthlyBalance +
                ", monthlydebittransactionsAmount=" + monthlydebittransactionsAmount +
                ", outgoinginttransactiondebitAmount=" + outgoinginttransactiondebitAmount +
                ", outgoinginttrndebitNumber=" + outgoinginttrndebitNumber +
                ", outgoinglocaltransactiondebitAmount=" + outgoinglocaltransactiondebitAmount +
                ", outgoinglocaltransactiondebitNumber=" + outgoinglocaltransactiondebitNumber +
                ", overdraftLimit=" + overdraftLimit +
                ", overthecounterwithdrawalsAmount=" + overthecounterwithdrawalsAmount +
                ", overthecounterwithdrawalsNumber=" + overthecounterwithdrawalsNumber +
                ", transactionValue=" + transactionValue +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Transactions() {

    }
    private double alternativechanneltrnscrAmount;
    private int alternativechanneltrnscrNumber;
    private double alternativechanneltrnsdebitAmount;
    private int alternativechanneltrnsdebitNumber;
    private int atmTransactionsNumber;
    private double atmtransactionsAmount;
    private int bouncedChequesDebitNumber;
    private int bouncedchequescreditNumber;
    private double bouncedchequetransactionscrAmount;
    private double bouncedchequetransactionsdrAmount;
    private double chequeDebitTransactionsAmount;
    private int chequeDebitTransactionsNumber;
    private Date createdAt;
    private Date createdDate;
    private double credittransactionsAmount;
    private double debitcardpostransactionsAmount;
    private int debitcardpostransactionsNumber;
    private double fincominglocaltransactioncrAmount;
    private int id;
    private double incominginternationaltrncrAmount;
    private int incominginternationaltrncrNumber;
    private int incominglocaltransactioncrNumber;
    private int intrestAmount;
    private Date lastTransactionDate;
    private int lastTransactionValue;
    private double maxAtmTransactions;
    private double maxMonthlyBebitTransactions;
    private double maxalternativechanneltrnscr;
    private double maxalternativechanneltrnsdebit;
    private double maxbouncedchequetransactionscr;
    private double maxchequedebittransactions;
    private double maxdebitcardpostransactions;
    private double maxincominginternationaltrncr;
    private double maxincominglocaltransactioncr;
    private double maxmobilemoneycredittrn;
    private double maxmobilemoneydebittransaction;
    private double maxmonthlycredittransactions;
    private double maxoutgoinginttrndebit;
    private double maxoutgoinglocaltrndebit;
    private double maxoverthecounterwithdrawals;
    private double minAtmTransactions;
    private double minMonthlyDebitTransactions;
    private double minalternativechanneltrnscr;
    private double minalternativechanneltrnsdebit;
    private double minbouncedchequetransactionscr;
    private double minchequedebittransactions;
    private double mindebitcardpostransactions;
    private double minincominginternationaltrncr;
    private double minincominglocaltransactioncr;
    private double minmobilemoneycredittrn;
    private double minmobilemoneydebittransaction;
    private double minmonthlycredittransactions;
    private double minoutgoinginttrndebit;
    private double minoutgoinglocaltrndebit;
    private double minoverthecounterwithdrawals;
    private double mobilemoneycredittransactionAmount;
    private int mobilemoneycredittransactionNumber;
    private double mobilemoneydebittransactionAmount;
    private int mobilemoneydebittransactionNumber;
    private double monthlyBalance;
    private double monthlydebittransactionsAmount;
    private double outgoinginttransactiondebitAmount;
    private int outgoinginttrndebitNumber;
    private double outgoinglocaltransactiondebitAmount;
    private int outgoinglocaltransactiondebitNumber;
    private double overdraftLimit;
    private double overthecounterwithdrawalsAmount;
    private int overthecounterwithdrawalsNumber;
    private double transactionValue;
    private Date updatedAt;

    public Transactions(double alternativechanneltrnscrAmount, int alternativechanneltrnscrNumber, double alternativechanneltrnsdebitAmount, int alternativechanneltrnsdebitNumber, int atmTransactionsNumber, double atmtransactionsAmount, int bouncedChequesDebitNumber, int bouncedchequescreditNumber, double bouncedchequetransactionscrAmount, double bouncedchequetransactionsdrAmount, double chequeDebitTransactionsAmount, int chequeDebitTransactionsNumber, Date createdAt, Date createdDate, double credittransactionsAmount, double debitcardpostransactionsAmount, int debitcardpostransactionsNumber, double fincominglocaltransactioncrAmount, int id, double incominginternationaltrncrAmount, int incominginternationaltrncrNumber, int incominglocaltransactioncrNumber, int intrestAmount, Date lastTransactionDate, int lastTransactionValue, double maxAtmTransactions, double maxMonthlyBebitTransactions, double maxalternativechanneltrnscr, double maxalternativechanneltrnsdebit, double maxbouncedchequetransactionscr, double maxchequedebittransactions, double maxdebitcardpostransactions, double maxincominginternationaltrncr, double maxincominglocaltransactioncr, double maxmobilemoneycredittrn, double maxmobilemoneydebittransaction, double maxmonthlycredittransactions, double maxoutgoinginttrndebit, double maxoutgoinglocaltrndebit, double maxoverthecounterwithdrawals, double minAtmTransactions, double minMonthlyDebitTransactions, double minalternativechanneltrnscr, double minalternativechanneltrnsdebit, double minbouncedchequetransactionscr, double minchequedebittransactions, double mindebitcardpostransactions, double minincominginternationaltrncr, double minincominglocaltransactioncr, double minmobilemoneycredittrn, double minmobilemoneydebittransaction, double minmonthlycredittransactions, double minoutgoinginttrndebit, double minoutgoinglocaltrndebit, double minoverthecounterwithdrawals, double mobilemoneycredittransactionAmount, int mobilemoneycredittransactionNumber, double mobilemoneydebittransactionAmount, int mobilemoneydebittransactionNumber, double monthlyBalance, double monthlydebittransactionsAmount, double outgoinginttransactiondebitAmount, int outgoinginttrndebitNumber, double outgoinglocaltransactiondebitAmount, int outgoinglocaltransactiondebitNumber, double overdraftLimit, double overthecounterwithdrawalsAmount, int overthecounterwithdrawalsNumber, double transactionValue, Date updatedAt) {
        this.alternativechanneltrnscrAmount = alternativechanneltrnscrAmount;
        this.alternativechanneltrnscrNumber = alternativechanneltrnscrNumber;
        this.alternativechanneltrnsdebitAmount = alternativechanneltrnsdebitAmount;
        this.alternativechanneltrnsdebitNumber = alternativechanneltrnsdebitNumber;
        this.atmTransactionsNumber = atmTransactionsNumber;
        this.atmtransactionsAmount = atmtransactionsAmount;
        this.bouncedChequesDebitNumber = bouncedChequesDebitNumber;
        this.bouncedchequescreditNumber = bouncedchequescreditNumber;
        this.bouncedchequetransactionscrAmount = bouncedchequetransactionscrAmount;
        this.bouncedchequetransactionsdrAmount = bouncedchequetransactionsdrAmount;
        this.chequeDebitTransactionsAmount = chequeDebitTransactionsAmount;
        this.chequeDebitTransactionsNumber = chequeDebitTransactionsNumber;
        this.createdAt = createdAt;
        this.createdDate = createdDate;
        this.credittransactionsAmount = credittransactionsAmount;
        this.debitcardpostransactionsAmount = debitcardpostransactionsAmount;
        this.debitcardpostransactionsNumber = debitcardpostransactionsNumber;
        this.fincominglocaltransactioncrAmount = fincominglocaltransactioncrAmount;
        this.id = id;
        this.incominginternationaltrncrAmount = incominginternationaltrncrAmount;
        this.incominginternationaltrncrNumber = incominginternationaltrncrNumber;
        this.incominglocaltransactioncrNumber = incominglocaltransactioncrNumber;
        this.intrestAmount = intrestAmount;
        this.lastTransactionDate = lastTransactionDate;
        this.lastTransactionValue = lastTransactionValue;
        this.maxAtmTransactions = maxAtmTransactions;
        this.maxMonthlyBebitTransactions = maxMonthlyBebitTransactions;
        this.maxalternativechanneltrnscr = maxalternativechanneltrnscr;
        this.maxalternativechanneltrnsdebit = maxalternativechanneltrnsdebit;
        this.maxbouncedchequetransactionscr = maxbouncedchequetransactionscr;
        this.maxchequedebittransactions = maxchequedebittransactions;
        this.maxdebitcardpostransactions = maxdebitcardpostransactions;
        this.maxincominginternationaltrncr = maxincominginternationaltrncr;
        this.maxincominglocaltransactioncr = maxincominglocaltransactioncr;
        this.maxmobilemoneycredittrn = maxmobilemoneycredittrn;
        this.maxmobilemoneydebittransaction = maxmobilemoneydebittransaction;
        this.maxmonthlycredittransactions = maxmonthlycredittransactions;
        this.maxoutgoinginttrndebit = maxoutgoinginttrndebit;
        this.maxoutgoinglocaltrndebit = maxoutgoinglocaltrndebit;
        this.maxoverthecounterwithdrawals = maxoverthecounterwithdrawals;
        this.minAtmTransactions = minAtmTransactions;
        this.minMonthlyDebitTransactions = minMonthlyDebitTransactions;
        this.minalternativechanneltrnscr = minalternativechanneltrnscr;
        this.minalternativechanneltrnsdebit = minalternativechanneltrnsdebit;
        this.minbouncedchequetransactionscr = minbouncedchequetransactionscr;
        this.minchequedebittransactions = minchequedebittransactions;
        this.mindebitcardpostransactions = mindebitcardpostransactions;
        this.minincominginternationaltrncr = minincominginternationaltrncr;
        this.minincominglocaltransactioncr = minincominglocaltransactioncr;
        this.minmobilemoneycredittrn = minmobilemoneycredittrn;
        this.minmobilemoneydebittransaction = minmobilemoneydebittransaction;
        this.minmonthlycredittransactions = minmonthlycredittransactions;
        this.minoutgoinginttrndebit = minoutgoinginttrndebit;
        this.minoutgoinglocaltrndebit = minoutgoinglocaltrndebit;
        this.minoverthecounterwithdrawals = minoverthecounterwithdrawals;
        this.mobilemoneycredittransactionAmount = mobilemoneycredittransactionAmount;
        this.mobilemoneycredittransactionNumber = mobilemoneycredittransactionNumber;
        this.mobilemoneydebittransactionAmount = mobilemoneydebittransactionAmount;
        this.mobilemoneydebittransactionNumber = mobilemoneydebittransactionNumber;
        this.monthlyBalance = monthlyBalance;
        this.monthlydebittransactionsAmount = monthlydebittransactionsAmount;
        this.outgoinginttransactiondebitAmount = outgoinginttransactiondebitAmount;
        this.outgoinginttrndebitNumber = outgoinginttrndebitNumber;
        this.outgoinglocaltransactiondebitAmount = outgoinglocaltransactiondebitAmount;
        this.outgoinglocaltransactiondebitNumber = outgoinglocaltransactiondebitNumber;
        this.overdraftLimit = overdraftLimit;
        this.overthecounterwithdrawalsAmount = overthecounterwithdrawalsAmount;
        this.overthecounterwithdrawalsNumber = overthecounterwithdrawalsNumber;
        this.transactionValue = transactionValue;
        this.updatedAt = updatedAt;
    }

    @XmlElement(name = "ns2:alternativechanneltrnscrAmount")
    public double getAlternativechanneltrnscrAmount() {
        return alternativechanneltrnscrAmount;
    }

    @XmlElement(name = "ns2:alternativechanneltrnscrNumber")
    public int getAlternativechanneltrnscrNumber() {
        return alternativechanneltrnscrNumber;
    }

    @XmlElement(name = "ns2:alternativechanneltrnsdebitAmount")
    public double getAlternativechanneltrnsdebitAmount() {
        return alternativechanneltrnsdebitAmount;
    }

    @XmlElement(name = "ns2:alternativechanneltrnsdebitNumber")
    public int getAlternativechanneltrnsdebitNumber() {
        return alternativechanneltrnsdebitNumber;
    }
    @XmlElement(name = "ns2:atmTransactionsNumber")
    public int getAtmTransactionsNumber() {
        return atmTransactionsNumber;
    }
    @XmlElement(name = "ns2:atmtransactionsAmount")
    public double getAtmtransactionsAmount() {
        return atmtransactionsAmount;
    }
    @XmlElement(name = "ns2:bouncedChequesDebitNumber")
    public int getBouncedChequesDebitNumber() {
        return bouncedChequesDebitNumber;
    }
    @XmlElement(name = "ns2:bouncedchequescreditNumber")
    public int getBouncedchequescreditNumber() {
        return bouncedchequescreditNumber;
    }
    @XmlElement(name = "ns2:bouncedchequetransactionscrAmount")
    public double getBouncedchequetransactionscrAmount() {
        return bouncedchequetransactionscrAmount;
    }
    @XmlElement(name = "ns2:bouncedchequetransactionsdrAmount")
    public double getBouncedchequetransactionsdrAmount() {
        return bouncedchequetransactionsdrAmount;
    }
    @XmlElement(name = "ns2:chequeDebitTransactionsAmount")
    public double getChequeDebitTransactionsAmount() {
        return chequeDebitTransactionsAmount;
    }
    @XmlElement(name = "ns2:chequeDebitTransactionsNumber")
    public int getChequeDebitTransactionsNumber() {
        return chequeDebitTransactionsNumber;
    }
    @XmlElement(name = "ns2:createdAt", namespace = "http://credable.io/cbs/transaction")
//    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getCreatedAt() {
        return createdAt;
    }
    @XmlElement(name = "ns2:createdDate")
    public Date getCreatedDate() {
        return createdDate;
    }
    @XmlElement(name = "ns2:credittransactionsAmount")
    public double getCredittransactionsAmount() {
        return credittransactionsAmount;
    }
    @XmlElement(name = "ns2:debitcardpostransactionsAmount")
    public double getDebitcardpostransactionsAmount() {
        return debitcardpostransactionsAmount;
    }
    @XmlElement(name = "ns2:debitcardpostransactionsNumber")
    public int getDebitcardpostransactionsNumber() {
        return debitcardpostransactionsNumber;
    }
    @XmlElement(name = "ns2:fincominglocaltransactioncrAmount")
    public double getFincominglocaltransactioncrAmount() {
        return fincominglocaltransactioncrAmount;
    }
    @XmlElement(name = "ns2:id")
    public int getId() {
        return id;
    }
    @XmlElement(name = "ns2:incominginternationaltrncrAmount")
    public double getIncominginternationaltrncrAmount() {
        return incominginternationaltrncrAmount;
    }
    @XmlElement(name = "ns2:incominginternationaltrncrNumber")
    public int getIncominginternationaltrncrNumber() {
        return incominginternationaltrncrNumber;
    }
    @XmlElement(name = "ns2:incominglocaltransactioncrNumber")
    public int getIncominglocaltransactioncrNumber() {
        return incominglocaltransactioncrNumber;
    }
    @XmlElement(name = "ns2:intrestAmount")
    public int getIntrestAmount() {
        return intrestAmount;
    }
    @XmlElement(name = "ns2:lastTransactionDate")
    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }
    @XmlElement(name = "ns2:lastTransactionValue")
    public int getLastTransactionValue() {
        return lastTransactionValue;
    }
    @XmlElement(name = "ns2:maxAtmTransactions")
    public double getMaxAtmTransactions() {
        return maxAtmTransactions;
    }
    @XmlElement(name = "ns2:maxMonthlyBebitTransactions")
    public double getMaxMonthlyBebitTransactions() {
        return maxMonthlyBebitTransactions;
    }
    @XmlElement(name = "ns2:maxalternativechanneltrnscr")
    public double getMaxalternativechanneltrnscr() {
        return maxalternativechanneltrnscr;
    }
    @XmlElement(name = "ns2:maxalternativechanneltrnsdebit")
    public double getMaxalternativechanneltrnsdebit() {
        return maxalternativechanneltrnsdebit;
    }
    @XmlElement(name = "ns2:maxbouncedchequetransactionscr")
    public double getMaxbouncedchequetransactionscr() {
        return maxbouncedchequetransactionscr;
    }
    @XmlElement(name = "ns2:maxchequedebittransactions")
    public double getMaxchequedebittransactions() {
        return maxchequedebittransactions;
    }
    @XmlElement(name = "ns2:maxdebitcardpostransactions")
    public double getMaxdebitcardpostransactions() {
        return maxdebitcardpostransactions;
    }
    @XmlElement(name = "ns2:maxincominginternationaltrncr")
    public double getMaxincominginternationaltrncr() {
        return maxincominginternationaltrncr;
    }
    @XmlElement(name = "ns2:maxincominglocaltransactioncr")
    public double getMaxincominglocaltransactioncr() {
        return maxincominglocaltransactioncr;
    }
    @XmlElement(name = "ns2:maxmobilemoneycredittrn")
    public double getMaxmobilemoneycredittrn() {
        return maxmobilemoneycredittrn;
    }
    @XmlElement(name = "ns2:maxmobilemoneydebittransaction")
    public double getMaxmobilemoneydebittransaction() {
        return maxmobilemoneydebittransaction;
    }
    @XmlElement(name = "ns2:maxmonthlycredittransactions")
    public double getMaxmonthlycredittransactions() {
        return maxmonthlycredittransactions;
    }
    @XmlElement(name = "ns2:maxoutgoinginttrndebit")
    public double getMaxoutgoinginttrndebit() {
        return maxoutgoinginttrndebit;
    }
    @XmlElement(name = "ns2:maxoutgoinglocaltrndebit")
    public double getMaxoutgoinglocaltrndebit() {
        return maxoutgoinglocaltrndebit;
    }
    @XmlElement(name = "ns2:maxoverthecounterwithdrawals")
    public double getMaxoverthecounterwithdrawals() {
        return maxoverthecounterwithdrawals;
    }
    @XmlElement(name = "ns2:minAtmTransactions")
    public double getMinAtmTransactions() {
        return minAtmTransactions;
    }
    @XmlElement(name = "ns2:minMonthlyDebitTransactions")
    public double getMinMonthlyDebitTransactions() {
        return minMonthlyDebitTransactions;
    }
    @XmlElement(name = "ns2:minalternativechanneltrnscr")
    public double getMinalternativechanneltrnscr() {
        return minalternativechanneltrnscr;
    }
    @XmlElement(name = "ns2:minalternativechanneltrnsdebit")
    public double getMinalternativechanneltrnsdebit() {
        return minalternativechanneltrnsdebit;
    }
    @XmlElement(name = "ns2:minbouncedchequetransactionscr")
    public double getMinbouncedchequetransactionscr() {
        return minbouncedchequetransactionscr;
    }
    @XmlElement(name = "ns2:minchequedebittransactions")
    public double getMinchequedebittransactions() {
        return minchequedebittransactions;
    }
    @XmlElement(name = "ns2:mindebitcardpostransactions")
    public double getMindebitcardpostransactions() {
        return mindebitcardpostransactions;
    }
    @XmlElement(name = "ns2:minincominginternationaltrncr")
    public double getMinincominginternationaltrncr() {
        return minincominginternationaltrncr;
    }
    @XmlElement(name = "ns2:minincominglocaltransactioncr")
    public double getMinincominglocaltransactioncr() {
        return minincominglocaltransactioncr;
    }
    @XmlElement(name = "ns2:minmobilemoneycredittrn")
    public double getMinmobilemoneycredittrn() {
        return minmobilemoneycredittrn;
    }
    @XmlElement(name = "ns2:minmobilemoneydebittransaction")
    public double getMinmobilemoneydebittransaction() {
        return minmobilemoneydebittransaction;
    }
    @XmlElement(name = "ns2:minmonthlycredittransactions")
    public double getMinmonthlycredittransactions() {
        return minmonthlycredittransactions;
    }
    @XmlElement(name = "ns2:minoutgoinginttrndebit")
    public double getMinoutgoinginttrndebit() {
        return minoutgoinginttrndebit;
    }
    @XmlElement(name = "ns2:minoutgoinglocaltrndebit")
    public double getMinoutgoinglocaltrndebit() {
        return minoutgoinglocaltrndebit;
    }
    @XmlElement(name = "ns2:minoverthecounterwithdrawals")
    public double getMinoverthecounterwithdrawals() {
        return minoverthecounterwithdrawals;
    }
    @XmlElement(name = "ns2:mobilemoneycredittransactionAmount")
    public double getMobilemoneycredittransactionAmount() {
        return mobilemoneycredittransactionAmount;
    }
    @XmlElement(name = "ns2:mobilemoneycredittransactionNumber")
    public int getMobilemoneycredittransactionNumber() {
        return mobilemoneycredittransactionNumber;
    }
    @XmlElement(name = "ns2:mobilemoneydebittransactionAmount")
    public double getMobilemoneydebittransactionAmount() {
        return mobilemoneydebittransactionAmount;
    }
    @XmlElement(name = "ns2:mobilemoneydebittransactionNumber")
    public int getMobilemoneydebittransactionNumber() {
        return mobilemoneydebittransactionNumber;
    }
    @XmlElement(name = "ns2:monthlyBalance")
    public double getMonthlyBalance() {
        return monthlyBalance;
    }
    @XmlElement(name = "ns2:monthlydebittransactionsAmount")
    public double getMonthlydebittransactionsAmount() {
        return monthlydebittransactionsAmount;
    }
    @XmlElement(name = "ns2:outgoinginttransactiondebitAmount")
    public double getOutgoinginttransactiondebitAmount() {
        return outgoinginttransactiondebitAmount;
    }
    @XmlElement(name = "ns2:outgoinginttrndebitNumber")
    public int getOutgoinginttrndebitNumber() {
        return outgoinginttrndebitNumber;
    }
    @XmlElement(name = "ns2:outgoinglocaltransactiondebitAmount")
    public double getOutgoinglocaltransactiondebitAmount() {
        return outgoinglocaltransactiondebitAmount;
    }
    @XmlElement(name = "ns2:outgoinglocaltransactiondebitNumber")
    public int getOutgoinglocaltransactiondebitNumber() {
        return outgoinglocaltransactiondebitNumber;
    }
    @XmlElement(name = "ns2:overdraftLimit")
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    @XmlElement(name = "ns2:overthecounterwithdrawalsAmount")
    public double getOverthecounterwithdrawalsAmount() {
        return overthecounterwithdrawalsAmount;
    }
    @XmlElement(name = "ns2:overthecounterwithdrawalsNumber")
    public int getOverthecounterwithdrawalsNumber() {
        return overthecounterwithdrawalsNumber;
    }
    @XmlElement(name = "ns2:transactionValue")
    public double getTransactionValue() {
        return transactionValue;
    }
    @XmlElement(name = "ns2:updatedAt")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setAlternativechanneltrnscrAmount(double alternativechanneltrnscrAmount) {
        this.alternativechanneltrnscrAmount = alternativechanneltrnscrAmount;
    }

    public void setAlternativechanneltrnscrNumber(int alternativechanneltrnscrNumber) {
        this.alternativechanneltrnscrNumber = alternativechanneltrnscrNumber;
    }

    public void setAlternativechanneltrnsdebitAmount(double alternativechanneltrnsdebitAmount) {
        this.alternativechanneltrnsdebitAmount = alternativechanneltrnsdebitAmount;
    }

    public void setAlternativechanneltrnsdebitNumber(int alternativechanneltrnsdebitNumber) {
        this.alternativechanneltrnsdebitNumber = alternativechanneltrnsdebitNumber;
    }

    public void setAtmTransactionsNumber(int atmTransactionsNumber) {
        this.atmTransactionsNumber = atmTransactionsNumber;
    }

    public void setAtmtransactionsAmount(double atmtransactionsAmount) {
        this.atmtransactionsAmount = atmtransactionsAmount;
    }

    public void setBouncedChequesDebitNumber(int bouncedChequesDebitNumber) {
        this.bouncedChequesDebitNumber = bouncedChequesDebitNumber;
    }

    public void setBouncedchequescreditNumber(int bouncedchequescreditNumber) {
        this.bouncedchequescreditNumber = bouncedchequescreditNumber;
    }

    public void setBouncedchequetransactionscrAmount(double bouncedchequetransactionscrAmount) {
        this.bouncedchequetransactionscrAmount = bouncedchequetransactionscrAmount;
    }

    public void setBouncedchequetransactionsdrAmount(double bouncedchequetransactionsdrAmount) {
        this.bouncedchequetransactionsdrAmount = bouncedchequetransactionsdrAmount;
    }

    public void setChequeDebitTransactionsAmount(double chequeDebitTransactionsAmount) {
        this.chequeDebitTransactionsAmount = chequeDebitTransactionsAmount;
    }

    public void setChequeDebitTransactionsNumber(int chequeDebitTransactionsNumber) {
        this.chequeDebitTransactionsNumber = chequeDebitTransactionsNumber;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCredittransactionsAmount(double credittransactionsAmount) {
        this.credittransactionsAmount = credittransactionsAmount;
    }

    public void setDebitcardpostransactionsAmount(double debitcardpostransactionsAmount) {
        this.debitcardpostransactionsAmount = debitcardpostransactionsAmount;
    }

    public void setDebitcardpostransactionsNumber(int debitcardpostransactionsNumber) {
        this.debitcardpostransactionsNumber = debitcardpostransactionsNumber;
    }

    public void setFincominglocaltransactioncrAmount(double fincominglocaltransactioncrAmount) {
        this.fincominglocaltransactioncrAmount = fincominglocaltransactioncrAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIncominginternationaltrncrAmount(double incominginternationaltrncrAmount) {
        this.incominginternationaltrncrAmount = incominginternationaltrncrAmount;
    }

    public void setIncominginternationaltrncrNumber(int incominginternationaltrncrNumber) {
        this.incominginternationaltrncrNumber = incominginternationaltrncrNumber;
    }

    public void setIncominglocaltransactioncrNumber(int incominglocaltransactioncrNumber) {
        this.incominglocaltransactioncrNumber = incominglocaltransactioncrNumber;
    }

    public void setIntrestAmount(int intrestAmount) {
        this.intrestAmount = intrestAmount;
    }

    public void setLastTransactionDate(Date lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public void setLastTransactionValue(int lastTransactionValue) {
        this.lastTransactionValue = lastTransactionValue;
    }

    public void setMaxAtmTransactions(double maxAtmTransactions) {
        this.maxAtmTransactions = maxAtmTransactions;
    }

    public void setMaxMonthlyBebitTransactions(double maxMonthlyBebitTransactions) {
        this.maxMonthlyBebitTransactions = maxMonthlyBebitTransactions;
    }

    public void setMaxalternativechanneltrnscr(double maxalternativechanneltrnscr) {
        this.maxalternativechanneltrnscr = maxalternativechanneltrnscr;
    }

    public void setMaxalternativechanneltrnsdebit(double maxalternativechanneltrnsdebit) {
        this.maxalternativechanneltrnsdebit = maxalternativechanneltrnsdebit;
    }

    public void setMaxbouncedchequetransactionscr(double maxbouncedchequetransactionscr) {
        this.maxbouncedchequetransactionscr = maxbouncedchequetransactionscr;
    }

    public void setMaxchequedebittransactions(double maxchequedebittransactions) {
        this.maxchequedebittransactions = maxchequedebittransactions;
    }

    public void setMaxdebitcardpostransactions(double maxdebitcardpostransactions) {
        this.maxdebitcardpostransactions = maxdebitcardpostransactions;
    }

    public void setMaxincominginternationaltrncr(double maxincominginternationaltrncr) {
        this.maxincominginternationaltrncr = maxincominginternationaltrncr;
    }

    public void setMaxincominglocaltransactioncr(double maxincominglocaltransactioncr) {
        this.maxincominglocaltransactioncr = maxincominglocaltransactioncr;
    }

    public void setMaxmobilemoneycredittrn(double maxmobilemoneycredittrn) {
        this.maxmobilemoneycredittrn = maxmobilemoneycredittrn;
    }

    public void setMaxmobilemoneydebittransaction(double maxmobilemoneydebittransaction) {
        this.maxmobilemoneydebittransaction = maxmobilemoneydebittransaction;
    }

    public void setMaxmonthlycredittransactions(double maxmonthlycredittransactions) {
        this.maxmonthlycredittransactions = maxmonthlycredittransactions;
    }

    public void setMaxoutgoinginttrndebit(double maxoutgoinginttrndebit) {
        this.maxoutgoinginttrndebit = maxoutgoinginttrndebit;
    }

    public void setMaxoutgoinglocaltrndebit(double maxoutgoinglocaltrndebit) {
        this.maxoutgoinglocaltrndebit = maxoutgoinglocaltrndebit;
    }

    public void setMaxoverthecounterwithdrawals(double maxoverthecounterwithdrawals) {
        this.maxoverthecounterwithdrawals = maxoverthecounterwithdrawals;
    }

    public void setMinAtmTransactions(double minAtmTransactions) {
        this.minAtmTransactions = minAtmTransactions;
    }

    public void setMinMonthlyDebitTransactions(double minMonthlyDebitTransactions) {
        this.minMonthlyDebitTransactions = minMonthlyDebitTransactions;
    }

    public void setMinalternativechanneltrnscr(double minalternativechanneltrnscr) {
        this.minalternativechanneltrnscr = minalternativechanneltrnscr;
    }

    public void setMinalternativechanneltrnsdebit(double minalternativechanneltrnsdebit) {
        this.minalternativechanneltrnsdebit = minalternativechanneltrnsdebit;
    }

    public void setMinbouncedchequetransactionscr(double minbouncedchequetransactionscr) {
        this.minbouncedchequetransactionscr = minbouncedchequetransactionscr;
    }

    public void setMinchequedebittransactions(double minchequedebittransactions) {
        this.minchequedebittransactions = minchequedebittransactions;
    }

    public void setMindebitcardpostransactions(double mindebitcardpostransactions) {
        this.mindebitcardpostransactions = mindebitcardpostransactions;
    }

    public void setMinincominginternationaltrncr(double minincominginternationaltrncr) {
        this.minincominginternationaltrncr = minincominginternationaltrncr;
    }

    public void setMinincominglocaltransactioncr(double minincominglocaltransactioncr) {
        this.minincominglocaltransactioncr = minincominglocaltransactioncr;
    }

    public void setMinmobilemoneycredittrn(double minmobilemoneycredittrn) {
        this.minmobilemoneycredittrn = minmobilemoneycredittrn;
    }

    public void setMinmobilemoneydebittransaction(double minmobilemoneydebittransaction) {
        this.minmobilemoneydebittransaction = minmobilemoneydebittransaction;
    }

    public void setMinmonthlycredittransactions(double minmonthlycredittransactions) {
        this.minmonthlycredittransactions = minmonthlycredittransactions;
    }

    public void setMinoutgoinginttrndebit(double minoutgoinginttrndebit) {
        this.minoutgoinginttrndebit = minoutgoinginttrndebit;
    }

    public void setMinoutgoinglocaltrndebit(double minoutgoinglocaltrndebit) {
        this.minoutgoinglocaltrndebit = minoutgoinglocaltrndebit;
    }

    public void setMinoverthecounterwithdrawals(double minoverthecounterwithdrawals) {
        this.minoverthecounterwithdrawals = minoverthecounterwithdrawals;
    }

    public void setMobilemoneycredittransactionAmount(double mobilemoneycredittransactionAmount) {
        this.mobilemoneycredittransactionAmount = mobilemoneycredittransactionAmount;
    }

    public void setMobilemoneycredittransactionNumber(int mobilemoneycredittransactionNumber) {
        this.mobilemoneycredittransactionNumber = mobilemoneycredittransactionNumber;
    }

    public void setMobilemoneydebittransactionAmount(double mobilemoneydebittransactionAmount) {
        this.mobilemoneydebittransactionAmount = mobilemoneydebittransactionAmount;
    }

    public void setMobilemoneydebittransactionNumber(int mobilemoneydebittransactionNumber) {
        this.mobilemoneydebittransactionNumber = mobilemoneydebittransactionNumber;
    }

    public void setMonthlyBalance(double monthlyBalance) {
        this.monthlyBalance = monthlyBalance;
    }

    public void setMonthlydebittransactionsAmount(double monthlydebittransactionsAmount) {
        this.monthlydebittransactionsAmount = monthlydebittransactionsAmount;
    }

    public void setOutgoinginttransactiondebitAmount(double outgoinginttransactiondebitAmount) {
        this.outgoinginttransactiondebitAmount = outgoinginttransactiondebitAmount;
    }

    public void setOutgoinginttrndebitNumber(int outgoinginttrndebitNumber) {
        this.outgoinginttrndebitNumber = outgoinginttrndebitNumber;
    }

    public void setOutgoinglocaltransactiondebitAmount(double outgoinglocaltransactiondebitAmount) {
        this.outgoinglocaltransactiondebitAmount = outgoinglocaltransactiondebitAmount;
    }

    public void setOutgoinglocaltransactiondebitNumber(int outgoinglocaltransactiondebitNumber) {
        this.outgoinglocaltransactiondebitNumber = outgoinglocaltransactiondebitNumber;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public void setOverthecounterwithdrawalsAmount(double overthecounterwithdrawalsAmount) {
        this.overthecounterwithdrawalsAmount = overthecounterwithdrawalsAmount;
    }

    public void setOverthecounterwithdrawalsNumber(int overthecounterwithdrawalsNumber) {
        this.overthecounterwithdrawalsNumber = overthecounterwithdrawalsNumber;
    }

    public void setTransactionValue(double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
