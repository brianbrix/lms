package com.company.lms.model.soap;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ns2:TransactionsResponse")
public class TransactionsResponse {
    public TransactionsResponse(){}
    private List<Transactions> transactions;

    public TransactionsResponse(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @XmlElement(name = "ns2:transactions")
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "transactions=" + transactions +
                '}';
    }
}
