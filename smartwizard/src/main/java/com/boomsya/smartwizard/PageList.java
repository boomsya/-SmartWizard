package com.boomsya.smartwizard;

import java.util.ArrayList;

/**
 * Represents a list of wizard pages.
 */
public class PageList extends ArrayList<Page> implements PageTreeNode {

	private static final long serialVersionUID = -2829971774651385639L;

	public PageList(Page... pages) {
        for (Page page : pages) {
            add(page);
        }
    }

    @Override
    public Page findByKey(String key) {
        for (Page childPage : this) {
            Page found = childPage.findByKey(key);
            if (found != null) return found;
        }

        return null;
    }

    public Page findByClassName(Class classname) {
        for (Page childPage : this) {
			if(childPage.getClass() == classname) {
				return childPage;
			}
        }

        return null;
    }

    @Override
    public void flattenCurrentPageSequence(ArrayList<Page> dest) {
        for (Page childPage : this) {
            childPage.flattenCurrentPageSequence(dest);
        }
    }
}