As you probably know, JSF 2.2 comes with a significant number of events, but none of them is published right after the view is rendered. With other words, the PreRenderViewEvent doesn't have a "friend" of type PostRenderViewEvent. Well, starting with JSF 2.3 this is not true anymore, because PostRenderViewEvent is available and comes to add consistency to JSF events suite.

Arjan Tijms page: http://arjan-tijms.omnifaces.org/p/jsf-23.html
OmniFaces blog:   http://www.omnifaces-fans.org/2015/10/just-tested-jsf-23-postrenderviewevent.html