package src.java.problems.companies;

import java.util.*;

public class Klarna2 {

    public static void main(String[] args) {
        List<String> in = Arrays.asList("Jane,Doe,jane@doe.com,201,TR0001","Jane,Doe,jane@doe.com,201,TR0002"
        , "Jane,Doe,jane1@doe.com,201,TR0003");
        int c = 200;
        List<String> r = findRejectedTransactions(in, c);
        System.out.println(r);
    }

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        Map<String, TxnApprovedReject> txnApprovedRejectHashMap = new HashMap<>();

        for(String txn : transactions){
            String[] txnArray = txn.split(",");
            String email = txnArray[2];
            String tranId = txnArray[4];
            int txnAmt = Integer.parseInt(txnArray[3]);

            if(txnApprovedRejectHashMap.containsKey(email)){
                int approvedTxSoFar = txnApprovedRejectHashMap.get(email).totalAmountApproved;
                int newApprovedTxAmt = approvedTxSoFar+txnAmt;
                if(newApprovedTxAmt > creditLimit){
                    txnApprovedRejectHashMap.get(email).txnRejected.add(tranId);
                } else {
                    txnApprovedRejectHashMap.get(email).totalAmountApproved = newApprovedTxAmt;
                }
            } else {
                txnApprovedRejectHashMap.put(email, new TxnApprovedReject(new ArrayList<String>(), 0));
                if(txnAmt > creditLimit){
                    txnApprovedRejectHashMap.get(email).txnRejected.add(tranId);
                } else {
                    txnApprovedRejectHashMap.get(email).totalAmountApproved = txnAmt;
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        for(TxnApprovedReject t : txnApprovedRejectHashMap.values()){
            resultList.addAll(t.txnRejected);
        }
        Collections.sort(resultList);
        return resultList.isEmpty() ? Collections.emptyList() : resultList;
    }

    static class TxnApprovedReject {
        List<String> txnRejected = null;
        int totalAmountApproved = 0;

        public TxnApprovedReject(List<String> txn, int totalAmountApproved) {
            this.txnRejected = txn;
            this.totalAmountApproved = totalAmountApproved;
        }

        public TxnApprovedReject() {
        }
    }
}
