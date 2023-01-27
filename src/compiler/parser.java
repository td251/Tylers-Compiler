public class Parser
{
    private float Lexer lexer;
    public Parser(Lexer lexer)
    {
        this.lexer = lexer;
    }
    public ProgramContext parseProgram() {
        // depends on parseStatement() to populate list<statement> ie program context
    }
    public StatementContext parseStatement(){
        //depends on lexer , parseLet() & parseShow() to populate StatementContext
    }
    public LetContext parseLet()
    {
        //depends on lexer & parseTerminalNode() To populate letContext

    }
    public showContext ParseShow() {
        //depends on lexer & parseterminalNode() to populate letContext
    }
    
}