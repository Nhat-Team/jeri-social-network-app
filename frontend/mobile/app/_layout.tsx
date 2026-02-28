import HeaderComponent from "@/components/HeaderComponent";
import { store } from "@/redux/store";
import { Stack } from "expo-router";
import { Provider } from "react-redux";

export default function RootLayout() {
  return (
    <Provider store={store}>
      <Stack>
        <Stack.Screen name="(tabs)" options={{ headerShown: false }} />
        <Stack.Screen name="login" options={{ headerShown: false }} />
        <Stack.Screen name="register" options={{ headerShown: false }} />
        <Stack.Screen
          name="search"
          options={{ header: () => <HeaderComponent /> }}
        />
      </Stack>
    </Provider>
  );
}
