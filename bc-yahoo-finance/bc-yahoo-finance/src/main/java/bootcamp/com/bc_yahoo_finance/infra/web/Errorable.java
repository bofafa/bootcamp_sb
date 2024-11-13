package bootcamp.com.bc_yahoo_finance.infra.web;

public interface Errorable {
  int getCode();
  String getMessage();
}