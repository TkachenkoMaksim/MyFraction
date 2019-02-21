package com.mtkachenko;

import java.util.Iterator;

public interface DescendingIterator<T> {//для обратного порядка
    Iterator<T> descendingIterator();
}
