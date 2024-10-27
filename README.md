# OIBSIP_ATM
Task 3 of Oasis Byte Internship. 
# ATM Simulator

This project is an ATM Simulator. It simulates real ATM functionalities, allowing users to log in, view transaction history, withdraw money, deposit money & transfer money.

## How It Works:

1. **Registration & Login**: Users register with a unique name and PIN. They log in to access the ATM menu if credentials match.
2. **Menu Options**:
   - **1. View Transaction History**
   - **2. Withdraw Money**
   - **3. Deposit Money**
   - **4. Transfer Money** (with a valid 12-digit account number)
   - **5. Exit** (ends the session)

3. **Transaction Handling**: Each transaction updates the user's balance and logs it in the transaction history.

## Code Overview:

- **Classes**:
   - `ATM`: Manages the main functions, user input, and menu.
   - `User`: Stores user details (`name`, `pin`, `balance`).
- **Key Methods**:
   - `registerUser()`, `authenticateUser()`, `withdraw()`, `deposit()`, `transfer()`, `transaction()`.
