package com.webdriver;

public class Java_Assignment1 {

	

	 // dimension of input
	 static int N = 9;

	 // sample input
	 static int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, //
	   { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, //
	   { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, //
	   { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, //
	   { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, //
	   { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, //
	   { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, //
	   { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, //
	   { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

	 /**
	  * Class to abstract the representation of a cell. Cell => (x, y)
	  */
	 static class Cell {

	  int row, col;

	  public Cell(int row, int col) {
	   super();
	   this.row = row;
	   this.col = col;
	  }

	  @Override
	  public String toString() {
	   return "Cell [row=" + row + ", col=" + col + "]";
	  }
	 };

	 /**
	  * Utility function to check whether @param value is valid for @param cell
	  */

	 static boolean isValid(Cell cell, int value) {

	  if (grid[cell.row][cell.col] != 0) {
	   throw new RuntimeException(
	     "Cannot call for cell which already has a value");
	  }

	  // if v present row, return false
	  for (int c = 0; c < 9; c++) {
	   if (grid[cell.row][c] == value)
	    return false;
	  }

	  // if v present in col, return false
	  for (int r = 0; r < 9; r++) {
	   if (grid[r][cell.col] == value)
	    return false;
	  }

	  // if v present in grid, return false

	  // to get the grid we should calculate (x1,y1) (x2,y2)
	  int x1 = 3 * (cell.row / 3);
	  int y1 = 3 * (cell.col / 3);
	  int x2 = x1 + 2;
	  int y2 = y1 + 2;

	  for (int x = x1; x <= x2; x++)
	   for (int y = y1; y <= y2; y++)
	    if (grid[x][y] == value)
	     return false;

	  return true;
	 }

	 static Cell getNextCell(Cell cur) {

	  int row = cur.row;
	  int col = cur.col;

	  col++;

	  if (col > 8) {
	   
	   col = 0;
	   row++;
	  }

	  if (row > 8)
	   return null;

	  Cell next = new Cell(row, col);
	  return next;
	 }

	
	 static boolean solve(Cell cur) {

	
	  if (cur == null)
	   return true;

	
	  if (grid[cur.row][cur.col] != 0) {
	 
	   return solve(getNextCell(cur));
	  }

	  for (int i = 1; i <= 9; i++) {
	   // check if valid, if valid, then update
	   boolean valid = isValid(cur, i);

	   if (!valid) 
	    continue;

	  
	   grid[cur.row][cur.col] = i;

	   
	   boolean solved = solve(getNextCell(cur));
	   
	   if (solved)
	    return true;
	   else
	    grid[cur.row][cur.col] = 0; 
	   // continue with other possible values
	  }

	  // if you reach here, then no value from 1 - 9 for this cell can solve
	  // return false
	  return false;
	 }

	 public static void main(String[] args) {
	  boolean solved = solve(new Cell(0, 0));
	  if (!solved) {
	   System.out.println("SUDOKU cannot be solved.");
	   return;
	  }
	  System.out.println("SOLUTION\n");
	  printGrid(grid);
	 }

	 // utility to print the grid
	 static void printGrid(int grid[][]) {
	  for (int row = 0; row < N; row++) {
	   for (int col = 0; col < N; col++)
	    System.out.print(grid[row][col]);
	   System.out.println();
	  }
	 }

	
}
