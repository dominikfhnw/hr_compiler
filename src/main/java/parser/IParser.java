package parser;
import errors.GrammarError;

public interface IParser {

    ConcSyn.IProgram parse() throws GrammarError;

}
