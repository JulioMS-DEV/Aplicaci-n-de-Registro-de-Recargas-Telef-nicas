package ni.edu.uam.app_recarga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ni.edu.uam.app_recarga.ui.theme.App_RecargaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_RecargaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RechargeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RechargeScreen(modifier: Modifier = Modifier) {
    // --- ESTADOS (Preparados para Integrante 2 y 3) ---
    var phoneNumber by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var selectedCompany by remember { mutableStateOf("") }
    var showResult by remember { mutableStateOf(false) }

    // Lista de compañías para el selector (Integrante 2)
    val companies = listOf("Claro", "Tigo")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Título Principal (Integrante 1)
        Text(
            text = "Mis Recargas",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo para el número de teléfono (Integrante 1)
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Número de Teléfono") },
            placeholder = { Text("Ej. 8888 8888") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true
        )

        // Campo para el monto de la recarga (Integrante 1)
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Monto de la Recarga") },
            placeholder = { Text("C$ 0.00") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        // ============================================================
        // SECCIÓN PARA INTEGRANTE 2: Selector y Acción
        // ============================================================
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selectedCompany,
                onValueChange = {},
                readOnly = true,
                label = { Text("Seleccionar Compañía") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                companies.forEach { company ->
                    DropdownMenuItem(
                        text = { Text(company) },
                        onClick = {
                            selectedCompany = company
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        Button(
            onClick = {
                // Validación de campos (no vacíos)
                if (phoneNumber.isNotBlank() && amount.isNotBlank() && selectedCompany.isNotBlank()) {
                    showResult = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar Recarga")
        }

        // ============================================================
        // SECCIÓN PARA INTEGRANTE 3: Resultado Visual
        // ============================================================
        
        if (showResult) {
            // TODO: Mostrar Card con los datos registrados
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RechargeScreenPreview() {
    App_RecargaTheme {
        RechargeScreen()
    }
}
