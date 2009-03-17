/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package remote;

import common.BankException;

public interface AccountManagerIF
{
   String[] getAccount(String number);
   String[][] getTransactions(String number);
   String newAccount(double newLimit, String newName, String newPincode) throws BankException;
   String setOpen(boolean b);
}
