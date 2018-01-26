package com.rajan.streams.tradersProblem;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TraderProblems {

	public List<Transaction> getTransactionsIn2011Sorted(List<Transaction> transactions) {
		return transactions.stream().filter((transaction) -> transaction.getYear() == 2011)
				.sorted((transaction1, transaction2) -> transaction1.getValue() - transaction2.getValue())
				.collect(toList());
	}

	public List<String> getUniqueCitiesOfTraders(List<Transaction> transactions) {
		return transactions.stream().map((transaction) -> transaction.getTrader().getCity()).distinct()
				.collect(toList());
	}

	public List<Trader> getAllTradersFromCitySorted(List<Transaction> transactions, String city) {
		return transactions.stream().map((transaction) -> transaction.getTrader())
				.filter((trader) -> trader.getCity() == city)
				.sorted((trader1, trader2) -> trader1.getName().compareTo(trader2.getName())).distinct()
				.collect(toList());
	}

	public List<String> getAllTraderNameSorted(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted(String::compareTo)
				.collect(toList());
	}

	public boolean isAnyTraderBasedInGivenCity(List<Transaction> transactions, String city) {
		return transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity() == city);
	}

	public void printAllTransactionValuesForACity(List<Transaction> transactions, String city) {
		transactions.stream().filter(transaction -> transaction.getTrader().getCity() == city)
				.map(transaction -> transaction.getValue()).forEach(System.out::println);
	}

	public Optional<Integer> getHeighestValueOfTransaction(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::max);
	}

	public Optional<Integer> getSmallestTransaction(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> transaction.getValue()).reduce(Integer::min);
	}

	public static void main(String[] args) {
		Trader roul = new Trader("Roul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(roul, 2012, 1000), new Transaction(roul, 2011, 400), new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		System.out.println("All transactions of 2011 in sorted order: ");
		System.out.println(new TraderProblems().getTransactionsIn2011Sorted(transactions));

		System.out.println("All unique cities of traders: ");
		System.out.println(new TraderProblems().getUniqueCitiesOfTraders(transactions));

		System.out.println("Find traders by city in sorted order: ");
		System.out.println(new TraderProblems().getAllTradersFromCitySorted(transactions, "Milan"));

		System.out.println("Get all traders name in sorted order ");
		System.out.println(new TraderProblems().getAllTraderNameSorted(transactions));

		System.out.println("Find if there is any trader based in given city: ");
		System.out.println(new TraderProblems().isAnyTraderBasedInGivenCity(transactions, "Cambridge1"));

		System.out.println("Print transaction values for a given city: ");
		new TraderProblems().printAllTransactionValuesForACity(transactions, "Cambridge");

		System.out.println("Get maximum value of a transaction: ");
		System.out.println(new TraderProblems().getHeighestValueOfTransaction(transactions).toString());
	}
}
