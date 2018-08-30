package PoketGem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lingyanjiang on 17/2/27.
 */
class View {
    int viewId;
    List<Button> buttons;

    public View(int viewId) {
        this.viewId = viewId;
        buttons = new ArrayList<>();
    }

    public View(int viewId, List<Button> buttons) {
        this.viewId = viewId;
        this.buttons = buttons;
    }

    public void addButton(Button button) {
        buttons.add(button);
    }
}

class Button {
    int currentView;
    int targetView;

    public Button(int currentView, int targetView) {
        this.currentView = currentView;
        this.targetView = targetView;
    }

    @Override
    public int hashCode() {
        return this.currentView * 31 + this.targetView;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Button) {
            Button button = (Button) object;
            return this.currentView == button.currentView && this.targetView == button.targetView;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Button:" + this.currentView + "->" + this.targetView;
    }
}

public class ViewsAndButtons {
    public List<List<Button>> findSolution(List<View> views) {
        List<List<Button>> res = new ArrayList<>();
        if (views == null || views.size() < 1) return res;
        List<Button> visited = new ArrayList<>();
        int n = 0;
        for (View view : views) {
            n += view.buttons.size();
        }
        for (View v : views) {
            dfs(v, views, res, visited, n);
        }
        for (List<Button> b : res) {
            for (Button button : b) {
                System.out.print(button);
            }
            System.out.println();
        }
        return res;
    }

    private void dfs(View cur, List<View> views, List<List<Button>> res, List<Button> visited, int n) {
        if (visited.size() == n) {
            res.add(new ArrayList(visited));
            return;
        }

        for (Button button : cur.buttons) {
            if (visited.contains(button)) continue;
            visited.add(button);
            View nextView = views.get(button.targetView);
            dfs(nextView, views, res, visited, n);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) {
        View v1 = new View(0);
        View v2 = new View(1);
        View v3 = new View(2);
        List<View> views = new ArrayList<>();
        views.add(v1);
        views.add(v2);
        views.add(v3);
//        v1.addButton(new Button(0, 1));
//        v1.addButton(new Button(0, 2));
//        v2.addButton(new Button(1, 0));
//        v3.addButton(new Button(2, 0));
        v1.addButton(new Button(0, 1));
        v2.addButton(new Button(1, 2));
//        v3.addButton(new Button(2, 1));
        new ViewsAndButtons().findSolution(views);
    }

}
