package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.DataBase.DatabaseHelper;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentStorageAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentStorageTransactionDAO;

public class PersistentStorageExpenseManager extends ExpenseManager {
    private DatabaseHelper db;
    public PersistentStorageExpenseManager(DatabaseHelper db) {
        this.db = db;
        setup();
    }

    @Override
    public void setup() {

        TransactionDAO persistentTransactionDAO = new PersistentStorageTransactionDAO(db);
        setTransactionsDAO(persistentTransactionDAO);

        AccountDAO persistentAccountDAO = new PersistentStorageAccountDAO(db);
        setAccountsDAO(persistentAccountDAO);

    }
}

