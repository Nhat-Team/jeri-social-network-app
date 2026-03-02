import {configureStore} from "@reduxjs/toolkit";
import colorSchemeReducer from "./slices/colorSchemeSlice";
import languageReducer from "./slices/languageSlice";
import userReducer from "./slices/userSlice";

export const store = configureStore({
    reducer: {
        colorScheme: colorSchemeReducer,
        language: languageReducer,
        user: userReducer
    }
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;