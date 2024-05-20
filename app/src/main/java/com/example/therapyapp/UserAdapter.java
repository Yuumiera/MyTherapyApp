package com.example.therapyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> users;

    public UserAdapter(@NonNull Context context, List<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        }

        User user = users.get(position);

        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewDisorder = convertView.findViewById(R.id.textViewDisorder);

        // Eski işlevler burada olacak

        // Eğer kullanıcı odaya girmişse, bir işaret göster
        if (user.userInRoom()) {
            // Örnek olarak, kullanıcı adının yanında bir işaret gösterelim
            textViewName.setText(user.getName() + " ✓");
        } else {
            // Odada değilse, normal kullanıcı adını göster
            textViewName.setText(user.getName());
        }

        // Diğer özellikleri de göster
        textViewDisorder.setText(user.getDisorder());

        return convertView;
    }
}
