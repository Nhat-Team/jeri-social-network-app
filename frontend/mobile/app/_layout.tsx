import HeaderComponent from "@/components/HeaderComponent";
import AccountAndSecurityHeaderComponent from "@/components/header/AccountAndSecurityHeaderComponent";
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
        <Stack.Screen
          name="profile/account_and_security"
          options={{ header: () => <AccountAndSecurityHeaderComponent /> }}
        />
      </Stack>
    </Provider>
  );
}
