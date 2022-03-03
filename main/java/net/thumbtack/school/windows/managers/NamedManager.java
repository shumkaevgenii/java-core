package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class NamedManager<T> extends Manager {
    private String Name;

    public NamedManager(T Window, String Name) throws WindowException {
        super((net.thumbtack.school.windows.v4.base.Window) Window);
        if(Name == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) throws WindowException {
        if(Name == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.Name = Name;
    }
}
