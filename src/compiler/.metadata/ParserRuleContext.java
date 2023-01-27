public class ParserRuleContext implements ParseTree{
    public ParseTree parent;

    public List<ParseTree> children;

    @Override
    public parseTree getParent(){

    }
    @override
    public void setParents(ParseTree parent)
    {

    }
    @Override
    public String getText()
    {

    }
    @Override
    public Object getPayLoad()
    {
        return this;
    }
    public void  addChild(ParseTree child)
    {
        child.setParent(this);
        if(children== null) children = new ArrayList<>();
        children.add(child);
    }
    @Override
    public ParseTree getChild(int i)
    {
        return this.children.get(i);
    }
    @Override
    public int getChildCount(){
        return children != null ? children.size() : 0
    }
    @Override
    public String toStringTree(){}
    @override
    public<T> T accept(Vistors<? extends T> visitor)
    {
        return null;
    }


}