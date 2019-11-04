package step;

import page.IPage;

public interface IStep<E extends IPage> {

    E getPage();

    void clickOrderButton();

}
