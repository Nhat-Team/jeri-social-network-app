import {Stack} from "expo-router";
import {store} from "@/redux/store";
import {Provider} from "react-redux";
import HeaderComponent from "@/components/header";

export default function RootLayout() {
    return (
        <Provider store={store}>
            <Stack>
                <Stack.Screen name="(tabs)" options={{headerShown: false}} />
                <Stack.Screen name="login" options={{headerShown: false}} />
                <Stack.Screen name="register" options={{headerShown: false}} />
                <Stack.Screen name="search" options={{ header: () => <HeaderComponent/> }} />
            </Stack>
        </Provider>
    )
}