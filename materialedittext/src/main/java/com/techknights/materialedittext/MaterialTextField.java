package com.techknights.materialedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MaterialTextField extends FrameLayout {

    protected View card;
    protected ImageView image;
    protected EditText editText;
    protected ViewGroup editTextLayout;

    protected int labelTopMargin = -1;
    protected boolean expanded = false;

    protected int imageDrawableId = -1;
    protected int cardCollapsedHeight = -1;
    protected boolean hasFocus = false;

    protected float reducedScale = 0.2f;

    public MaterialTextField(Context context) {
        super(context);
    }

    public MaterialTextField(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleAttributes(context, attrs);
    }

    public MaterialTextField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleAttributes(context, attrs);
    }

    public View getCard() {
        return card;
    }

    public ImageView getImage() {
        return image;
    }

    public EditText getEditText() {
        return editText;
    }

    public ViewGroup getEditTextLayout() {
        return editTextLayout;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
        final InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);

        if (focused != null) {
            setHasFocus(true);
        } else {
            setHasFocus(false);
        }
    }

    protected void handleAttributes(Context context, AttributeSet attrs) {
        try {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.MaterialTextField);
            {
                imageDrawableId = styledAttrs.getResourceId(R.styleable.MaterialTextField_mtf_image, -1);
            }
            {
                hasFocus = styledAttrs.getBoolean(R.styleable.MaterialTextField_mtf_hasFocus, false);
            }

            styledAttrs.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected EditText findEditTextChild() {
        if (getChildCount() > 0 && getChildAt(0) instanceof EditText) {
            return (EditText) getChildAt(0);
        }
        return null;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        editText = findEditTextChild();
        if (editText == null) {
            return;
        }

        addView(LayoutInflater.from(getContext()).inflate(R.layout.mtf_layout, this, false));

        editTextLayout = (ViewGroup) findViewById(R.id.mtf_editTextLayout);
        removeView(editText);
        editTextLayout.addView(editText);

        card = findViewById(R.id.mtf_card);

        final int expandedHeight = getContext().getResources().getDimensionPixelOffset(R.dimen.mtf_cardHeight_final);
        final int reducedHeight = cardCollapsedHeight;

        reducedScale = (float) (reducedHeight * 1.0 / expandedHeight);

        image = (ImageView) findViewById(R.id.mtf_image);
        editText.setBackgroundColor(Color.TRANSPARENT);

        customizeFromAttributes();

        setHasFocus(hasFocus);
    }

    protected void customizeFromAttributes() {
        if (imageDrawableId != -1) {
            this.image.setImageDrawable(getContext().getResources().getDrawable(imageDrawableId));
        }
    }

}
