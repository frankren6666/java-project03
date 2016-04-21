package src.stacks;
/**
 * Provides the navigation feature of class BrowserNavigation by recording visited links
 * and then keeping a stack of "back" links and a stack of "forward" links.
 */
public class Navigator
{
    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    Navigator()
    {
        this.currentLink = "";
        this.backLinks = new StackList<String>();        
        this.forwardLinks = new StackList<String>();
    }

    /**
     * @return the currentLink
     */
    public String getCurrentLink()
    {
        return currentLink;
    }

    /**
     * sets the current links to given link
     * @param link [type: String]
     */
    public void setCurrentLink(String link)
    {        
        // if current link is not null
        if(!getCurrentLink().isEmpty())
        {
            // Places the old currentLink on the backLinks stack.        
            backLinks.push(getCurrentLink());
        }

        this.currentLink = link;        
    }

    /**
     * update the currentLink to the link at the top of the backLinks stack 
     */
    public void goBack()
    {            
        if (getBackLinks().isEmpty())
        {
            return;
        }
        //else            
        forwardLinks.push(getCurrentLink());        
        this.currentLink =  backLinks.pop();
    }

    /**
     * update the currentLink to the link at the top of the forwardLinks stack 
     */
    public void goForward()
    {
        if (getForwardLinks().isEmpty())
        {
            return;
        }
        //else
        this.currentLink = forwardLinks.pop();
    }

    public StackList<String> getBackLinks()
    {
        // TODO Auto-generated method stub
        return this.backLinks;
    }

    public StackList<String> getForwardLinks()
    {
        // TODO Auto-generated method stub
        return this.forwardLinks;
    }
}
