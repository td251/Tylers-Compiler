package compiler;

import java.util.Arrays;

public class tokenizer {
	  private final String code;
	  private final int codeLength;
	  private int currentIndex;
	  private Token currentToken; 
	  private Token previousToken;
	  public Lexer(String code) {
	    this.code = code;
	    this.currentIndex = 0;
	    this.codeLength = code.length();
	  }
	  //updates current token to the next valid token if it is available 
	  public boolean nextToken() {
		  while (!isEndOfCode()) {
			  previousToken = currentToken;
			  final char currentChar = code.charAt(currentIndex);
			  if (Arrays.asList(' ', '\r', '\t', '\n').contains(currentChar)) { // 1. WS
				  skipWhiteSpace();
				  continue;
			  } else if (currentChar == '=') {
				  currentToken = new Token(TokenType.EQUALS_OPERATOR);
				  currentIndex++;
			  } else if (Character.isDigit(currentChar)) {
				  String variableName = readVariable();
				  if (variableName.equalsIgnoreCase("show")) {
					  currentToken = new Token(TokenType.show);
					  currentIndex++;
				  } else {
					  currentToken = new Token(TokenType.VARIABLE, variableName);

				  }
			  } else {
				  currentToken = new Token(TokenType.VARIABLE, variableName);
			  }
		  }else{
			  throw new LexerException("Token not defined.");
		  }
		  return true
	  }
	  return false;
	  }
	  private String readNumber() {
		  StringBuilder sb = new StringBuilder(); 
		  char currentChar = code.charAt(currentIndex);
		  while(!isEndOfCode() && Character.isDigit(currentChar)) {
			  sb.append(currentChar); 
			  currentIndex++; 
			  if(isEndOfCode()) break; 
			  currentChar = code.charAt(currentIndex);
		  }
		  return sb.toString();
	  }
	  //skip any whitespace 
	  private void skipWhiteSpace() {
		  while(!isEndOfCode()) {
			  if(Arrays.asList(' ', '\r', '\t', '\n').contains(code.charAt(currentIndex))) {
				  currentIndex++;
			  }else {
				  break;
			  }
			  }
		  }
	  
	  //checking if end of code has been reached
	  private boolean isEndOfCode() {
		  return currentIndex >= codeLength; 
	  }
	  //getting the current token 
	  public Token getCurrentToken() {
		  return currentToken; 
	  }
}
