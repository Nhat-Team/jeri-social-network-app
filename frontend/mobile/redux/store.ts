import {configureStore} from "@reduxjs/toolkit";
import colorSchemeReducer from "./slices/colorSchemeSlice";
import languageReducer from "./slices/languageSlice";

export const store = configureStore({
    reducer: {
        colorScheme: colorSchemeReducer,
        language: languageReducer,
    }
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;